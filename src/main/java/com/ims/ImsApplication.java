package com.ims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImsApplication.class, args);
        System.out.println("========================================");
        System.out.println("📦 IMS Application Started Successfully!");
        System.out.println("🌐 Access at: http://localhost:8080");
        System.out.println("🔐 Login: 24RP09739 / 24RP06926");
        System.out.println("========================================");
    }
}