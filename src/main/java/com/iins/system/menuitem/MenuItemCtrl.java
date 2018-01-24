package com.iins.system.menuitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class MenuItemCtrl {


    @Autowired
    private final MenuItemRepo menuItemRepo;

    public MenuItemCtrl(MenuItemRepo menuItemRepo) {
        this.menuItemRepo = menuItemRepo;
    }

    @PostConstruct
    private void initialization() {
        menuItemRepo.saveAll(Flux.just(
                new MenuItem("10", "Travel Insurance Quote", "travel_insurance_quote", "root", "Home"),
                new MenuItem("11", "History Quotes", "history_quotes", "root", "Home"),

                new MenuItem("21", "Active Customers", "customer_list", "customer", "Customer"),
                new MenuItem("22", "Contact", "contact", "customer", "Customer"),
                new MenuItem("24", "Address", "address", "customer", "Customer")//String id,String itemName,String itemKey,String parentId,String parentMenu
        )).subscribe();

    }

    /**
     * GET ALL Customers
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository

        Flux<MenuItem> menuItemFlux = menuItemRepo.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(menuItemFlux, MenuItem.class);
    }

    /**
     * //     * GET a MenuItems by parentID
     * //
     */
    public Mono<ServerResponse> getItemsByParentId(ServerRequest request) {
        // parse path-variable
        String parentId = request.pathVariable("parentId");
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        // get customer from repository
        Flux<MenuItem> menuItemFlux = menuItemRepo.findAll().filter((MenuItem item) -> parentId.equals(item.getParentId()));
        return menuItemFlux.collectList().flatMap(item -> {
            if (item.isEmpty()) return notFound;
            else return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(menuItemFlux, MenuItem.class);
        });
    }
}
