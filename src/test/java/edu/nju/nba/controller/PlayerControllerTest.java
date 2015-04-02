package edu.nju.nba.controller;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ui.Model;

public class PlayerControllerTest {
	
	@Test
	public void test() {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"src/main/webapp/WEB-INF/applicationContext.xml");
		PlayerController controller = ctx.getBean(PlayerController.class);
		Model model = null;
		controller.show("科比", model);
	}

}
