package edu.uoc.ds.adt.util;

import org.apache.commons.csv.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class CSVUtil {

    public static CSVParser getCVSParser(String filePath) {

        CSVParser csvParser = null;
        try {
//            System.out.println(filePath);
            InputStream inputStream = CSVUtil.class.getResourceAsStream(filePath);
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + filePath);
            }

            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return csvParser;
    }

}