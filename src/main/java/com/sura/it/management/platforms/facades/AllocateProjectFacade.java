package com.sura.it.management.platforms.facades;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.PlatformCapacity;
import com.sura.it.management.platforms.model.Project;
import com.sura.it.management.platforms.model.ProjectPlatform;
import com.sura.it.management.platforms.model.ProjectTeamMember;
import com.sura.it.management.platforms.model.enumerations.ProjectSize;
import com.sura.it.management.platforms.model.util.MessageType;
import com.sura.it.management.platforms.model.util.ValidationMessage;

public class AllocateProjectFacade {

	public static List<ValidationMessage> allocateNewProject(Project project) throws URISyntaxException, SQLException {
		List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
		for (ProjectPlatform platform: project.getPlatformsInvolved()) {
			//TODO: Tener en cuenta fechas!
			//platform.getStart();
			//platform.getFinish();
			
			PlatformCapacity capacity = PlatformFacade.getMaxCapacity(platform.getPlatform());
			Float capacityNumber = capacity.getCapacityConfiguration().get(platform.getSize());
			if (capacityNumber == null) {
				
				messages.add(new ValidationMessage(MessageType.ERROR, "La plataforma " + platform.getPlatform().getName() + " no posee configuración de capacidad para proyectos talla " + platform.getSize()));				
			} else {
				float requiredCapacity = capacityNumber.floatValue();
				for (ProjectTeamMember teamMember : PlatformFacade.getCurrentProjectCapacity(platform.getPlatform()) ) {
					if (teamMember.getCapacity()>=requiredCapacity) {
						messages.add(new ValidationMessage(MessageType.INFO, "Para la plataforma " + platform.getPlatform().getName() + " se ha asignado a " + teamMember.getName() + " con el rol " + teamMember.getRole()));
						//TODO: Allocate Resource?						
						platform.addTeamMember(teamMember);
						break;
					}
				}
				if (platform.getTeamMembers()==null || platform.getTeamMembers().size()==0) {
					messages.add(new ValidationMessage(MessageType.ERROR, "La plataforma " + platform.getPlatform().getName() + " no posee personas disponibles de capacidad para proyectos talla " + platform.getSize()));
				}
			}
			
		}
		return messages;		
	}
	
	public static void main(String[] args) throws URISyntaxException, SQLException {
		
		Platform platform1 = new Platform();
		platform1.setName("Plataforma 1");
		platform1.setId(5);
		platform1.setShortName("PLAT_1");

		Platform platform2 = new Platform();
		platform2.setName("Plataforma 2");
		platform2.setId(5);
		platform2.setShortName("PLAT_2");
	
		Platform platform3 = new Platform();
		platform3.setName("Plataforma 3");
		platform3.setId(5);
		platform3.setShortName("PLAT_3");

		
		
		Project p = new Project();
		p.setId(1);
		p.setName("Proyecto de Prueba");
		p.setSize(ProjectSize.L);
		p.setLeadPlatform(platform1);
		
		ProjectPlatform pp1 = new ProjectPlatform();
		pp1.setPlatform(platform1);
		pp1.setSize(ProjectSize.L);
		p.addPlatformInvolved(pp1);

		ProjectPlatform pp2 = new ProjectPlatform();
		pp2.setPlatform(platform2);
		pp2.setSize(ProjectSize.M);
		p.addPlatformInvolved(pp2);
		
		ProjectPlatform pp3 = new ProjectPlatform();
		pp3.setPlatform(platform3);
		pp3.setSize(ProjectSize.XL);
		p.addPlatformInvolved(pp3);
		
		List<ValidationMessage> messages = AllocateProjectFacade.allocateNewProject(p);
		System.out.println(messages);
		
		
	
	}
}
