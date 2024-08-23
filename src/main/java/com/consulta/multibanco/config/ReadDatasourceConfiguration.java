package com.consulta.multibanco.config;

import com.consulta.multibanco.properties.ReadDatasourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.consulta.multibanco.repository.read",
        entityManagerFactoryRef = "readEntityManagerFactory",
        transactionManagerRef = "readTranscationManager")
public class ReadDatasourceConfiguration {

    @Autowired
    private ReadDatasourceProperties properties;

    @Bean(name = "readDataSource")
    public DataSource readDataSource() {
        return DataSourceBuilder.create()
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword())
                .build();
    }

    @Bean(name = "readEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean readEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("readDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.consulta.multibanco.model")
                .persistenceUnit("readPU")
                .build();
    }

    @Bean(name = "readTranscationManager")
    public PlatformTransactionManager readTranscationManager(@Qualifier("readEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
