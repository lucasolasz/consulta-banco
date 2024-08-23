package com.consulta.multibanco.config;


import com.consulta.multibanco.properties.WriteDatasourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = "com.consulta.multibanco.repository.write",
        entityManagerFactoryRef = "writeEntityManagerFactory",
        transactionManagerRef = "transcationManager")
public class WriteDatasourceConfiguration {

    @Autowired
    private WriteDatasourceProperties properties;

    @Primary
    @Bean(name = "writeDataSource")
    public DataSource writeDataSource() {
        return DataSourceBuilder.create()
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword())
                .build();
    }

    @Primary
    @Bean(name = "writeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean writeEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("writeDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.consulta.multibanco.model")
                .persistenceUnit("writePU")
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager transcationManager(@Qualifier("writeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
