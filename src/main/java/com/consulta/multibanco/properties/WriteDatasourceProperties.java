package com.consulta.multibanco.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.write")
public class WriteDatasourceProperties {

    private String url;
    private String username;
    private String password;
}
