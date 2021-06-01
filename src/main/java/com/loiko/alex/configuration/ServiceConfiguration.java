package com.loiko.alex.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@Configuration
@ComponentScan("com.loiko.alex")
@Import(DatabaseConfiguration.class)
public class ServiceConfiguration {
}