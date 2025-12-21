package com.ou_solutions.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
	
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("users-service", r -> r
                .path("/users/**")  // Path predicate
                .filters(f -> f
                    .rewritePath("/users/(?<segment>.*)", "/users/${segment}"))
                .uri("lb://user-service")
            )
            .route("account-mgmt-service", r-> r
            		.path("/account/**")
            		.filters(f -> f.rewritePath("/account/(?<segment>.*)", "/account/${segment}"))
            		.uri("lb://account-service"))
            .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
