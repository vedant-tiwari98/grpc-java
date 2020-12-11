package com.example.grpc.server;

import com.example.grpc.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(9091).addService(new UserService()).build();
        server.start();

        System.out.println("Server started on "+server.getPort());
        server.awaitTermination();
    }
}
