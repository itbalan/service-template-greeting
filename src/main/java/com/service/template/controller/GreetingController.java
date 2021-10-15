package com.service.template.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.template.model.Greeting;

@RestController
@RequestMapping(value = "/test", headers = "accept=application/json")	
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	public int result;

	@GetMapping(value = "/", headers = "accept=application/json")
	public String hello() {
		return "hello...you are good to go....";
	}
	
	@GetMapping(value = "/service/1", headers = "accept=application/json")
	public String serviceOne() {
		return "hello...here you go with service 1....";
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/greeting")
	public Greeting postGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping ("/")
	public Greeting post1Greeting( ) {
		return new Greeting(counter.incrementAndGet(), String.format(template, "Bala"));
	}
	
	@GetMapping ("/add")
	public int add(@RequestParam int input) {
		result = result + input;
		return result;
	}
	
}