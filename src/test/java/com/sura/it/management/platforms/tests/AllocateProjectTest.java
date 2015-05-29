package com.sura.it.management.platforms.tests;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import com.sura.it.management.platforms.dataAccess.CapacityDataAccess;
import com.sura.it.management.platforms.facades.AllocateProjectFacade;
import com.sura.it.management.platforms.model.Platform;
import com.sura.it.management.platforms.model.PlatformCapacity;
import com.sura.it.management.platforms.model.Project;
import com.sura.it.management.platforms.model.ProjectPlatform;
import com.sura.it.management.platforms.model.enumerations.ProjectSize;
import com.sura.it.management.platforms.model.util.ValidationMessage;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllocateProjectTest extends TestCase {
	
	public static Test suite() {
		return new TestSuite(AllocateProjectTest.class);
	}

	public void testNewProject()  {
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
		
		List<ValidationMessage> messages;
		try {
			messages = AllocateProjectFacade.allocateNewProject(p);
			System.out.println(messages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(null, null);

	}
	
//	PlatformCapacity capacity = new PlatformCapacity();
//	capacity.setPlatform(platform);
//	capacity.setMaintenanceCapacity(0.4f);
//	capacity.setSupportCapacity(1.6f);

//	List<ProjectTeamMember> projectCapacity = new ArrayList<ProjectTeamMember>();
//	
//	ProjectTeamMember tm = new ProjectTeamMember();
//	tm.setId(1);
//	tm.setCapacity(0.5f);
//	tm.setName("Johan Ruíz");
//	tm.setRole(TeamMemberRole.Architect);
//	projectCapacity.add(tm);
//	
//	ProjectTeamMember tm2 = new ProjectTeamMember();
//	tm2.setId(1);
//	tm2.setCapacity(1f);
//	tm2.setName("Carlos Carmona");
//	tm2.setRole(TeamMemberRole.TeamMember);
//	projectCapacity.add(tm2);
//
//	capacity.setProjectCapacity(projectCapacity);
	
//	Hashtable<ProjectSize,Float> capacityConfiguration = new Hashtable<ProjectSize,Float>();
//	capacityConfiguration.put(ProjectSize.XL, new Float(1f));
//	capacityConfiguration.put(ProjectSize.L, new Float(0.8f));
//	capacityConfiguration.put(ProjectSize.M, new Float(0.5f));
//	capacityConfiguration.put(ProjectSize.S, new Float(0.3f));
//	
//	capacity.setCapacityConfiguration(capacityConfiguration);
	
}
