package com.example.dongdong;

import com.example.dongdong.service.CsvImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DongdongApplication implements CommandLineRunner {

    private final CsvImportService csvImportService;

    public DongdongApplication(CsvImportService csvImportService) {
        this.csvImportService = csvImportService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DongdongApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        csvImportService.importCsv();
    }
}