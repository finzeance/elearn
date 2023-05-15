package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.Privilege;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class PrivilegeService {
    private RestTemplate restTemplate;

    @Autowired
    public PrivilegeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/privilege")
    private String url;

    public List<Privilege> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Privilege>>() {
                }).getBody();
    }

    public Privilege getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Privilege>() {
                }).getBody();
    }

    public Privilege create(Privilege privilege) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(privilege),
                new ParameterizedTypeReference<Privilege>() {
                }).getBody();
    }

    public Privilege update(int id, Privilege privilege) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(privilege),
                new ParameterizedTypeReference<Privilege>() {
                }).getBody();
    }

    public Privilege delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Privilege>() {
                }).getBody();
    }
}
