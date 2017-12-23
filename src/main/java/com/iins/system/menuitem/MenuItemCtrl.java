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
                new MenuItem("10", "Profile", "cutomer_profile", "10", "Customer"),
                new MenuItem("11", "Contact Information", "cutomer_profile", "10", "Customer"),
                new MenuItem("21", "Quote", "cutomer_profile", "20", "Quote"),
                new MenuItem("22", "Calculator", "cutomer_profile", "20", "Quote")//String id,String itemName,String itemKey,String parentId,String parentMenu
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
        Flux<MenuItem> menuItemFlux = menuItemRepo.findAll().filter((MenuItem item) -> {
            return parentId.equals(item.getParentId());
        });
        return menuItemFlux.collectList().flatMap(item -> {
            if (item.isEmpty()) return notFound;
            else return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(menuItemFlux, MenuItem.class);
        });
    }
}
