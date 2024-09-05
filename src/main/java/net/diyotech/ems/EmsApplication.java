package net.diyotech.ems;

import net.diyotech.ems.model.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan
//@EnableAutoConfiguration
//@Configuration
@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EmsApplication.class, args);

		Project project = applicationContext.getBean(Project.class);
		System.out.println(project);
	}

}
