package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.Task;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class TaskService {
    private RestTemplate restTemplate;

    @Autowired
    public TaskService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/task")
    private String url;

    public List<Task> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {
                }).getBody();
    }

    public Task getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Task>() {
                }).getBody();
    }

    public Task create(Task task) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(task),
                new ParameterizedTypeReference<Task>() {
                }).getBody();
    }

    public Task update(int id, Task task) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(task),
                new ParameterizedTypeReference<Task>() {
                }).getBody();
    }

    public Task delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Task>() {
                }).getBody();
    }
}
