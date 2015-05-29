package com.sura.it.management.platforms.facades;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.sura.it.management.platforms.model.PlatformCapacity;
import com.sura.it.management.platforms.model.Project;
import com.sura.it.management.platforms.model.ProjectAllocation;
import com.sura.it.management.platforms.model.ProjectPlatform;
import com.sura.it.management.platforms.model.ProjectTeamMember;
import com.sura.it.management.platforms.model.enumerations.ProjectSize;
import com.sura.it.management.platforms.model.util.MessageType;
import com.sura.it.management.platforms.model.util.ValidationMessage;

public class AllocateProjectFacade {

	public static ProjectAllocation allocateNewProject(Project project) throws URISyntaxException, SQLException {
		ProjectAllocation allocation = new ProjectAllocation();
		allocation.setProject(project);
		List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
		for (ProjectPlatform platform: project.getPlatformsInvolved()) {
			//TODO: Tener en cuenta fechas!
			//platform.getStart();
			//platform.getFinish();

			PlatformCapacity capacity = PlatformFacade.getMaxCapacity(platform
					.getPlatform());
			Hashtable<ProjectSize, Float> capacityConfiguration = capacity
					.getCapacityConfiguration();
			if (capacityConfiguration == null) {
				messages.add(new ValidationMessage(
						MessageType.ERROR,
						"La plataforma "
								+ platform.getPlatform().getName()
								+ " no posee configuración de capacidad para proyectos talla "
								+ platform.getSize()));
			} else {
				Float capacityNumber = capacityConfiguration.get(
						platform.getSize());
				if (capacityNumber == null) {
					messages.add(new ValidationMessage(
							MessageType.ERROR,
							"La plataforma "
									+ platform.getPlatform().getName()
									+ " no posee configuración de capacidad para proyectos talla "
									+ platform.getSize()));
				} else {
					float requiredCapacity = capacityNumber.floatValue();
					messages.add(new ValidationMessage(MessageType.INFO,
							"Capacidad requerida en la plataforma "
									+ platform.getPlatform().getName() + " = "
									+ capacityNumber.toString()));
					for (ProjectTeamMember teamMember : PlatformFacade
							.getCurrentProjectCapacity(platform.getPlatform())) {
						messages.add(new ValidationMessage(MessageType.INFO,
								"Encontrado " + teamMember.getName()
										+ " con capacidad de "
										+ teamMember.getCapacity()));
						if (teamMember.getCapacity() >= requiredCapacity) {
							messages.add(new ValidationMessage(
									MessageType.INFO, "Para la plataforma "
											+ platform.getPlatform().getName()
											+ " se ha asignado a "
											+ teamMember.getName()
											+ " con el rol "
											+ teamMember.getRole()));
							// TODO: Allocate Resource? Fechas?							
							teamMember.setCapacity(requiredCapacity);
							teamMember.setProjectName(project.getName());
							teamMember.setProjectSize(platform.getSize());							
							platform.addTeamMember(teamMember);
							
							break;
						}
					}
					if (platform.getTeamMembers() == null
							|| platform.getTeamMembers().size() == 0) {
						messages.add(new ValidationMessage(
								MessageType.ERROR,
								"La plataforma "
										+ platform.getPlatform().getName()
										+ " no posee personas disponibles de capacidad para proyectos talla "
										+ platform.getSize()));
					}
				}
			}
		}
		allocation.setMessages(messages);
		return allocation;		
	}
}
