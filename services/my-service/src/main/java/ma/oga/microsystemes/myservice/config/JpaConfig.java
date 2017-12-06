package ma.oga.microsystemes.myservice.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class JpaConfig {
    @Bean
    @ConfigurationProperties(prefix="datasource.db-notification")
    public DataSource notificationDataSource() {
        return DataSourceBuilder.create().build();
    }
}
