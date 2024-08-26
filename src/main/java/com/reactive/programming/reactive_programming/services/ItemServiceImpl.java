package com.reactive.programming.reactive_programming.services;

import com.reactive.programming.reactive_programming.Repositories.ItemRepository;
import com.reactive.programming.reactive_programming.handlers.NotFoundException;
import com.reactive.programming.reactive_programming.models.Item;
import com.reactive.programming.reactive_programming.models.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Mono<Item> getById(Long id) {
        return itemRepository.findById(id).switchIfEmpty(Mono.error(new NotFoundException("No se encuentra item por id: " + id)));
    }

    @Override
    public Flux<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Mono<Item> save(ItemDto item) {
        return itemRepository.save(new Item(item.getName()));
    }

    public Mono<ResponseEntity<String>> deleteById(Long id) {
        return itemRepository.findById(id)
                .flatMap(item -> itemRepository.delete(item)
                        .then(Mono.just(ResponseEntity.ok("Item eliminado correctamente"))))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @Override
    public Mono<Item> update(Item item) {
        return itemRepository.findById(item.getId())
                .flatMap(existingItem -> {
                    existingItem.setName(item.getName());
                    return itemRepository.save(existingItem);
                })
                .switchIfEmpty(Mono.error(new NotFoundException("No se encuentra item por id: " + item.getId())));
    }
}
