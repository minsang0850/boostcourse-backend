package org.edwith.webbe.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "org.edwith.webbe.guestbook.dao",  "org.edwith.webbe.guestbook.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}