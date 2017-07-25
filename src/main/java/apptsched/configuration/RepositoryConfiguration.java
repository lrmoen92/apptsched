package apptsched.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Logan.Moen on 7/24/2017.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"apptsched.domain"})
@EnableJpaRepositories(basePackages = {"apptsched.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
