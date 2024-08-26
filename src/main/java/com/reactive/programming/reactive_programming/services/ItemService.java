package com.reactive.programming.reactive_programming.services;

import com.reactive.programming.reactive_programming.models.Item;
import com.reactive.programming.reactive_programming.models.dto.ItemDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemService {
    Mono<Item> getById(Long id);
    Flux<Item> getAll();
    Mono<Item> save(ItemDto item);
    Mono<Void> deleteById(Long id);
    Mono<Item> update(Item item);
}
