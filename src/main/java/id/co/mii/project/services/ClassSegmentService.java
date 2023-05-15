package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.ClassSegment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class ClassSegmentService {
    private RestTemplate restTemplate;

    @Autowired
    public ClassSegmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/classsegment")
    private String url;

    public List<ClassSegment> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ClassSegment>>() {
                }).getBody();
    }

    public ClassSegment getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ClassSegment>() {
                }).getBody();
    }

    public ClassSegment create(ClassSegment classSegment) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(classSegment),
                new ParameterizedTypeReference<ClassSegment>() {
                }).getBody();
    }

    public ClassSegment update(int id, ClassSegment classSegment) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(classSegment),
                new ParameterizedTypeReference<ClassSegment>() {
                }).getBody();
    }

    public ClassSegment delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<ClassSegment>() {
                }).getBody();
    }
}
