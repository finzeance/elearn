package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.Program;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class ProgramService {
    private RestTemplate restTemplate;

    @Autowired
    public ProgramService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/program")
    private String url;

    public List<Program> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Program>>() {
                }).getBody();
    }

    public Program getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Program>() {
                }).getBody();
    }

    public Program create(Program program) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(program),
                new ParameterizedTypeReference<Program>() {
                }).getBody();
    }

    public Program update(int id, Program program) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(program),
                new ParameterizedTypeReference<Program>() {
                }).getBody();
    }

    public Program delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Program>() {
                }).getBody();
    }
}