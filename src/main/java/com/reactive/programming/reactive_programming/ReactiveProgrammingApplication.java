package com.reactive.programming.reactive_programming;

import com.reactive.programming.reactive_programming.Repositories.ItemRepository;
import com.reactive.programming.reactive_programming.models.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveProgrammingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingApplication.class, args);}

	@Bean
	public CommandLineRunner initData(ItemRepository itemRepository){
		return args -> {
			Item item = new Item("ItemTest");
			itemRepository.save(item).subscribe();
		};
	}

}
