package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.UserClass;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class UserClassService {
    private RestTemplate restTemplate;

    @Autowired
    public UserClassService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/userclass")
    private String url;

    public List<UserClass> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserClass>>() {
                }).getBody();
    }

    public UserClass getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<UserClass>() {
                }).getBody();
    }

    public UserClass create(UserClass userClass) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(userClass),
                new ParameterizedTypeReference<UserClass>() {
                }).getBody();
    }

    public UserClass update(int id, UserClass userClass) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(userClass),
                new ParameterizedTypeReference<UserClass>() {
                }).getBody();
    }

    public UserClass delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<UserClass>() {
                }).getBody();
    }
}
