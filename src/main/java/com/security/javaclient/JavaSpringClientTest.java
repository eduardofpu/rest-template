package com.security.javaclient;

import com.security.model.StudenteEnty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {

        //Utilizando os metodos getForObject, getForEntity e exchange

        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v1/protected/estudents")
                .basicAuthorization("delfino","devdojo").build();

        StudenteEnty studente = restTemplate.getForObject("/{id}", StudenteEnty.class, 1);

        ResponseEntity<StudenteEnty> forEntty = restTemplate.getForEntity("/{id}", StudenteEnty.class, 2);

        StudenteEnty[] students = restTemplate.getForObject("/", StudenteEnty[].class);

        ResponseEntity<List<StudenteEnty>> exchange = restTemplate.exchange("/",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<StudenteEnty>>() {
                });

        System.out.println(studente);
        System.out.println(forEntty);
        System.out.println(forEntty.getBody());
        System.out.println(Arrays.toString(students));
        System.out.println(exchange.getBody());
    }
}
