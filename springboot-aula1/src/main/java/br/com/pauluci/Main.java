package br.com.pauluci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import br.com.pauluci.client.FilialClient;
import br.com.pauluci.client.model.Filial;

@SpringBootApplication
public class Main extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private FilialClient filialClient;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	@Override
	public void run(String... arg0) throws Exception {
		int i = 0;
		while(i < 2) {
			Filial filial = filialClient.recuper(10, 10);
			System.out.println(filial);
			
			Thread.sleep(60_000);
			i++;
		}
	}
}