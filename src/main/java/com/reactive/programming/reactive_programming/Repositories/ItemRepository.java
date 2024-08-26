package com.reactive.programming.reactive_programming.Repositories;

import com.reactive.programming.reactive_programming.models.Item;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ItemRepository extends ReactiveCrudRepository<Item, Long> {
}
