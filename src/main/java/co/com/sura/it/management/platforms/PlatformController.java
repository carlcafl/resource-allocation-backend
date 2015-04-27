package co.com.sura.it.management.platforms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.sura.it.management.platforms.bo.Platform;

@RestController
public class PlatformController {

	@RequestMapping("/platforms")
	public Platform platform(@RequestParam(value="id", defaultValue="") String id) {
		Platform p = new Platform();
		p.setId(1);
		p.setShortName("SEG");
		p.setName("Core de Seguros");
		return p;
	}
}
