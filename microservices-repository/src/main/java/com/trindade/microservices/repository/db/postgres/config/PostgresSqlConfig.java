package com.trindade.microservices.repository.db.postgres.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.trindade.microservices.repository.db.postgres")
public class PostgresSqlConfig {
}
