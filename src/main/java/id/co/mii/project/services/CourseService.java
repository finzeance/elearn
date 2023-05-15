package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.Course;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class CourseService {
    private RestTemplate restTemplate;

    @Autowired
    public CourseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/course")
    private String url;

    public List<Course> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Course>>() {
                }).getBody();
    }

    public Course getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Course>() {
                }).getBody();
    }

    public Course create(Course course) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(course),
                new ParameterizedTypeReference<Course>() {
                }).getBody();
    }

    public Course update(int id, Course course) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(course),
                new ParameterizedTypeReference<Course>() {
                }).getBody();
    }

    public Course delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Course>() {
                }).getBody();
    }
}
