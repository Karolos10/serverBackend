package com.example.server.resource;

import com.example.server.model.Response;
import com.example.server.service.implementation.ServerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/server")
public class ServerResource {
    private final ServerServiceImpl serverService;

    public ServerResource(ServerServiceImpl serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/list")
    public ResponseEntity<Response> getServers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("servers", serverService.list(30)))
                        .message("Servers retrieved successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
