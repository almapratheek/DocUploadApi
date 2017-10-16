package com.capone.endpoints;

import com.capone.model.ProductObject;
import com.capone.model.ProductObjects;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ProductController {
    @CrossOrigin
    @RequestMapping(value = "/getProducts", method = GET, produces = "application/json")
    public ResponseEntity<ProductObjects> getProducts() {

        ProductObjects response = new ProductObjects();
        response.setProducts(readFileInList("src/main/resources/Products.txt")
                .stream()
                .map(a -> a.split(","))
                .map(s -> new ProductObject(s[2],s[3],s[4],Double.parseDouble(s[5]),s[6]))
                .collect(Collectors.toList()));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static List<String> readFileInList(String fileName)
    {
        List<String> lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return lines;
    }
}
