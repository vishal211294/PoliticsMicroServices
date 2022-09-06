package com.ey.codelab.servicediscovery.politicalparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PoliticalPartyServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliticalPartyServiceDiscoveryApplication.class, args);
	}

}
