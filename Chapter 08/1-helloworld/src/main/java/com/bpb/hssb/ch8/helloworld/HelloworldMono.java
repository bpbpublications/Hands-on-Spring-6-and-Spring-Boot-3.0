package com.bpb.hssb.ch8.helloworld;

import reactor.core.publisher.Mono;

public class HelloworldMono {

	public static void main(String[] args) {

		Mono<String> frutMono = Mono.just("Apples");
		frutMono.log().subscribe();

        // Print all the items 
		// frutMono.subscribe(frut -> System.out.println(frut));
	}
}
