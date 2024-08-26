package com.reactive.programming.reactive_programming.controllers;

import com.reactive.programming.reactive_programming.Repositories.ItemRepository;
import com.reactive.programming.reactive_programming.models.Item;
import com.reactive.programming.reactive_programming.models.dto.ItemDto;
import com.reactive.programming.reactive_programming.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/getAll")
    public Flux<Item> getAllPets(){
        return itemService.getAll();
    }

    @PostMapping("/createItem")
    public Mono<Item> createItem(@RequestBody ItemDto item){
        return itemService.save(item);
    }

    @GetMapping("/getItem/{id}")
    public Mono<Item> getById(@PathVariable Long id){
        return itemService.getById(id);
    }

    @DeleteMapping("/deleteItem/{id}")
    public  Mono<ResponseEntity<String>> deleteById(@PathVariable Long id){
        return itemService.deleteById(id);
    }

    @PutMapping("/updateItem")
    public Mono<Item> updateItem(@RequestBody Item item){
        return itemService.update(item);
    }
 }
