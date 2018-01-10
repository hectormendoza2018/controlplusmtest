package com.asetecit.controlplusmtest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:${user.home}/datasource.properties")
public class AppConfig {

}
