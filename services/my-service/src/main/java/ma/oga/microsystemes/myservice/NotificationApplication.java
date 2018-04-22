package ma.oga.microsystemes.myservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class NotificationApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(NotificationApplication.class).run(args);
	}
}
