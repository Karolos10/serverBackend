package com.example.server;

import com.example.server.enumeration.Status;
import com.example.server.model.Server;
import com.example.server.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(ServerRepository serverRepository) {
		return args -> {
			serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "8", "Personal PC", "http://localhost:8080/server/image/server1.jpg", Status.SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.58", "Fedora Linux", "8", "Dell Tower", "http://localhost:8080/server/image/server2.jpg", Status.SERVER_DOWN));
			serverRepository.save(new Server(null, "192.168.1.21", "MS 2008", "8", "Web Server", "http://localhost:8080/server/image/server3.jpg", Status.SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.14", "Red Hat Enterprise Linux", "8", "Mail Server", "http://localhost:8080/server/image/server4.jpg", Status.SERVER_UP));
		};
	}

}
