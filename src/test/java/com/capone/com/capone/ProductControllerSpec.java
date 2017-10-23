package com.capone.com.capone;

import com.capone.model.ProductObjects;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerSpec {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/getProducts");
    }

    @Test
    public void getProducts() throws Exception {
        ResponseEntity<ProductObjects> response = template.getForEntity(base.toString(),
                ProductObjects.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void getProductsFilteredByCategory() throws Exception {
        ResponseEntity<ProductObjects> response = template.getForEntity(base.toString()+"?category=snacks,foods",
                ProductObjects.class);
        assertNotNull(response.getBody());
        assertTrue(!response.getBody().getProducts().isEmpty());
    }
}
