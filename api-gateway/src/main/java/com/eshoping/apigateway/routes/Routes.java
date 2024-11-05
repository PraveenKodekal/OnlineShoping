package com.eshoping.apigateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

	// product service - routing
	@Bean
	public RouterFunction<ServerResponse> productRoute(){
		return GatewayRouterFunctions.route("product_service")
				.route(RequestPredicates.path("api/product"), HandlerFunctions.http("http://localhost:8088"))
				.build();
	}
	
	//order service - routing
	@Bean
	public RouterFunction<ServerResponse> orderRoute(){
		return GatewayRouterFunctions.route("order_service")
				.route(RequestPredicates.path("api/order"), HandlerFunctions.http("http://localhost:8089"))
				.build();
	}
	
	//inventory service- routing
	@Bean
	public RouterFunction<ServerResponse> inventoryRoute(){
		return GatewayRouterFunctions.route("inventory_servie")
				.route(RequestPredicates.path("api/inventory/instock"), HandlerFunctions.http("http://localhost:8090"))
				.build();
	}
}




























