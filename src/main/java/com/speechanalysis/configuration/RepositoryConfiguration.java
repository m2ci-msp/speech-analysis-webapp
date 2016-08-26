package com.speechanalysis.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by pmusset on 6/20/16.
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.speechanalysis.model"})
@EnableJpaRepositories(basePackages = {"com.speechanalysis.repository"})
public class RepositoryConfiguration {
}
