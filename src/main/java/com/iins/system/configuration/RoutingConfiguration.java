package com.iins.system.configuration;


import com.iins.modules.customer.CustomerCtrl;
import com.iins.modules.quote.QuoteCtrl;
import com.iins.system.menuitem.MenuItemCtrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.http.MediaType;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> customerRouterFunction(CustomerCtrl customerCtrl) {
        return nest(path("/api/customer"), route(RequestPredicates.GET("/").and(accept(MediaType.APPLICATION_JSON)), customerCtrl::getAll));
//                .andRoute(GET("/api/customer/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::getCustomer)
//                .andRoute(POST("/api/customer/post").and(accept(MediaType.APPLICATION_JSON)), customerHandler::postCustomer)
//                .andRoute(PUT("/api/customer/put/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::putCustomer)
//                .andRoute(DELETE("/api/customer/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::deleteCustomer);
    }

    @Bean
    public RouterFunction<ServerResponse> menuRouterFunction(MenuItemCtrl menuItemCtrl) {
        return nest(path("/api/menu"), route(RequestPredicates.GET("/").and(accept(MediaType.APPLICATION_JSON)), menuItemCtrl::getAll)
                .andRoute(GET("/{parentId}").and(accept(MediaType.APPLICATION_JSON)), menuItemCtrl::getItemsByParentId));
//                .andRoute(POST("/api/customer/post").and(accept(MediaType.APPLICATION_JSON)), customerHandler::postCustomer)
//                .andRoute(PUT("/api/customer/put/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::putCustomer)
//                .andRoute(DELETE("/api/customer/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::deleteCustomer);
    }

    @Bean
    public RouterFunction<ServerResponse> quoteRouterFunction(QuoteCtrl quoteCtrl) {
        return nest(path("/api/quote"),
                route(RequestPredicates.GET("/trv").and(accept(MediaType.APPLICATION_JSON)), quoteCtrl::getAllTravelInsuranceQuote)
                .andRoute(RequestPredicates.POST("/trv").and(accept(MediaType.APPLICATION_JSON)), quoteCtrl::saveTravelInsuranceQuote)
        );
//                .andRoute(POST("/api/customer/post").and(accept(MediaType.APPLICATION_JSON)), customerHandler::postCustomer)
//                .andRoute(PUT("/api/customer/put/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::putCustomer)
//                .andRoute(DELETE("/api/customer/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), customerHandler::deleteCustomer);
    }
}