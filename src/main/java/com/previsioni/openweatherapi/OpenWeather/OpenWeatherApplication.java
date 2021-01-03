package com.previsioni.openweatherapi.OpenWeather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class OpenWeatherApplication {
	public static void main(String[] args) {
		SpringApplication.run(OpenWeatherApplication.class, args);

		Città.ScegliCittà();

		try {
			Chiamata.call_me();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
