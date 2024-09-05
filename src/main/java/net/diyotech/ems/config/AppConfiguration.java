package net.diyotech.ems.config;

import net.diyotech.ems.model.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfiguration {

    @Bean
    @Profile("prod")
    public Project onlineShoppingProject() {
        System.out.println("Inside bean creation");
        return Project.builder()
                .name("Online Shopping")
                .budget(10000d)
                .duration(1.5f)
                .build();
    }
}
