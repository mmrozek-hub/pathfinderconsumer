package com.pathfinder.consumer;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.pathfinder.consumer.model.Graph;

@SpringBootApplication
public class GraphConsumerApplication {

	private static final Logger log = LoggerFactory.getLogger(GraphConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GraphConsumerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

		Scanner scanner = new Scanner(System.in);

		String opt = "";
		do {
			opt = menu(scanner);
			switch (opt.charAt(0)) {
			case '1':
				createGraph(restTemplate);
				break;
			case '2':
				getGraph(restTemplate);
				break;
			case '3':
				updateGraph(restTemplate);
				break;
			case '4':
				deleteGraph(restTemplate);
				break;
			case '5':
				solve(restTemplate);
				break;

			}

		} while (!"0".equals(opt));

		return null;
	}

	private String menu(Scanner scanner) {
		String opt;
		System.out.println("\n[full smkoke test: 1 -> 2 -> 5 -> 3 -> 5 -> 4 -> 0]");
		System.out.println("Smoke-test graph menu: ");
		System.out.println("1: Create");
		System.out.println("2: Read (id:1)");
		System.out.println("3: Update (id:1)");
		System.out.println("4: Delete (id:1)");
		System.out.println("5: Dijkstra btwn 1-7");
		System.out.println("0: Exit");
		System.out.println("-----------------");
		System.out.println("?: ");
		opt = scanner.next();
		System.out.println("");
		return opt;
	}

	private void getGraph(RestTemplate restTemplate) {
		Graph quote = restTemplate.getForObject("http://localhost:8080/graphs/1", Graph.class);
		log.info(quote.toString());
	}

	private void createGraph(RestTemplate restTemplate) {
		Graph graph = new Graph("SmokeTestGraph", "1,2,3,4,5,6,7", "1-2,2-3,3-4,4-5,5-6,6-7,2-6");
		Graph postForObject = restTemplate.postForObject("http://localhost:8080/graphs/", graph, Graph.class);
		log.info(postForObject.toString());
	}

	private void updateGraph(RestTemplate restTemplate) {
		restTemplate.put("http://localhost:8080/graphs/1",
				new Graph("Super-SmokeTestGraph", "1,2,3,4,5,6,7,8,9", "1-2,2-3,3-4,4-5,5-6,6-7,7-8,8-9,2-6"));
	}

	private void deleteGraph(RestTemplate restTemplate) {
		restTemplate.delete("http://localhost:8080/graphs/1");
	}

	private void solve(RestTemplate restTemplate) {
		String quote = restTemplate.getForObject("http://localhost:8080/graphService/solve/1?begin=1&end=7",
				String.class);
		log.info(quote.toString());
	}
}
