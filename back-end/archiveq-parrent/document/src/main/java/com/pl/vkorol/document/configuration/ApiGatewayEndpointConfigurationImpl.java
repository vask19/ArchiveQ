package com.pl.vkorol.document.configuration;

import com.pl.endpoint.ApiGatewayEndpointConfiguration;
import com.pl.endpoint.entity.Endpoint;
import com.pl.endpoint.entity.HttpMethod;
import com.pl.endpoint.entity.Response;
import com.pl.endpoint.entity.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiGatewayEndpointConfigurationImpl implements ApiGatewayEndpointConfiguration {

    @Value("${api-gateway.url}")
    private String GATEWAY_URL;

    @PostConstruct
    public void startrOperation(){
        initMap();
        register();
    }

    @Override
    public void initMap() {
        endpointList.add(new Endpoint("/api/v1/product", HttpMethod.GET, Role.GUEST));
        endpointList.add(new Endpoint("/api/v1/product/getExternal", HttpMethod.GET, Role.GUEST));
        endpointList.add(new Endpoint("/api/v1/product", HttpMethod.POST, Role.ADMIN));
        endpointList.add(new Endpoint("/api/v1/product", HttpMethod.DELETE, Role.ADMIN));
        endpointList.add(new Endpoint("/api/v1/archive", HttpMethod.GET, Role.GUEST));
        endpointList.add(new Endpoint("/api/v1/archive", HttpMethod.POST, Role.USER));
        endpointList.add(new Endpoint("/api/v1/descriptor/archive", HttpMethod.POST, Role.USER));
        endpointList.add(new Endpoint("/api/v1/descriptor/archive", HttpMethod.GET, Role.USER));
        endpointList.add(new Endpoint("/api/v1/document/archive", HttpMethod.GET, Role.USER));
        endpointList.add(new Endpoint("/api/v1/document/archive/all", HttpMethod.GET, Role.USER));
        endpointList.add(new Endpoint("/api/v1/document/archive", HttpMethod.POST, Role.USER));
        endpointList.add(new Endpoint("/api/v1/document/create", HttpMethod.POST, Role.USER));
        endpointList.add(new Endpoint("/api/v1/document/search", HttpMethod.GET, Role.USER));
        endpointList.add(new Endpoint("/api/v1/document/search", HttpMethod.POST, Role.USER));
        endpointList.add(new Endpoint("/api/v1/document/upload", HttpMethod.POST, Role.USER));

    }

    @Override
    public void register() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Response> response = restTemplate.postForEntity(GATEWAY_URL, endpointList, Response.class);
        if (response.getStatusCode().isError()) throw new RuntimeException();
    }
}
