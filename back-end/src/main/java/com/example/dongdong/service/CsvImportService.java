package com.example.dongdong.service;

import com.example.dongdong.model.StreetVendor;
import com.example.dongdong.repository.StreetVendorRepository;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvImportService {
    private final StreetVendorRepository repository;

    public void importCsv() throws Exception {
        if (repository.count() > 0) {
            return;
        }

        var inputStream = getClass().getResourceAsStream("/data/허가노점.csv");
        var reader = new CSVReader(new InputStreamReader(inputStream, "UTF-8"));

        List<String[]> lines = reader.readAll();
        lines.remove(0);
        List<StreetVendor> vendors = new ArrayList<>();

        for (String[] line : lines) {
            if (line.length < 4) continue;

            StreetVendor vendor = new StreetVendor();
            vendor.setPermitDate(line[1]);
            vendor.setStallNumber(line[2]);
            vendor.setAddress(line[3]);

            vendors.add(vendor);
        }

        repository.saveAll(vendors);
    }
}