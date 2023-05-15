package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.TaskAssignment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class TaskAssignmentService {
    private RestTemplate restTemplate;

    @Autowired
    public TaskAssignmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/taskassignment")
    private String url;

    public List<TaskAssignment> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TaskAssignment>>() {
                }).getBody();
    }

    public TaskAssignment getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<TaskAssignment>() {
                }).getBody();
    }

    public TaskAssignment create(TaskAssignment taskAssignment) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(taskAssignment),
                new ParameterizedTypeReference<TaskAssignment>() {
                }).getBody();
    }

    public TaskAssignment update(int id, TaskAssignment taskAssignment) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(taskAssignment),
                new ParameterizedTypeReference<TaskAssignment>() {
                }).getBody();
    }

    public TaskAssignment delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<TaskAssignment>() {
                }).getBody();
    }
}
