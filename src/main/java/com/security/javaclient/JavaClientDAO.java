package com.security.javaclient;

import com.security.handler.RestResponseExceptionHandler;
import com.security.model.PageableResponse;
import com.security.model.StudenteEnty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JavaClientDAO {

    private RestTemplate restTemplate = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v1/protected/estudents")
            .basicAuthorization("delfino", "devdojo")
            .errorHandler(new RestResponseExceptionHandler())
            .build();

    private RestTemplate restTemplateAdmin = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v1/admin/estudents")
            .basicAuthorization("delfino", "devdojo")
            .errorHandler(new RestResponseExceptionHandler())
            .build();

    public StudenteEnty findById(long id) {
        return restTemplate.getForObject("/{id}", StudenteEnty.class, id);
        // ResponseEntity<StudenteEnty> forEntty = restTemplate.getForEntity("/{id}", StudenteEnty.class, id);
    }

    public List<StudenteEnty> listAll() {
        ResponseEntity<PageableResponse<StudenteEnty>> exchange = restTemplate.exchange("/?sort=id,desc&sort=name,asc",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<PageableResponse<StudenteEnty>>() {
                });
        return exchange.getBody().getContent();
    }

    public StudenteEnty save(StudenteEnty studente) {
        ResponseEntity<StudenteEnty> exchangePost = restTemplateAdmin.exchange("/", HttpMethod.POST, new HttpEntity<>(studente, createJSONHeaders()), StudenteEnty.class);

        return exchangePost.getBody();
    }

    public void update(StudenteEnty student) {
        restTemplateAdmin.put("/", student);
    }


    public void delete(long id) {
        restTemplateAdmin.delete("/{id}", id);
    }

    private static HttpHeaders createJSONHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;

    }

}
