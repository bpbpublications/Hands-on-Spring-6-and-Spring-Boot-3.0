package com.bpb.hssb.ch8.helloworld;

import reactor.core.publisher.Flux;

public class HelloworldFlux {

	public static void main(String[] args) {

		Flux<String> frutFlux = Flux.just("Apples", "Oranges", "Grapes", "Mangoes", "Bananas" );

		// Events
		frutFlux.log().subscribe();
        // Print all the items 
		frutFlux.subscribe(frut -> System.out.println(frut));
		 // Print first three items
		frutFlux.take(3).subscribe(frut -> System.out.println(frut));
	}
}
