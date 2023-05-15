package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.Segment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class SegmentService {
    private RestTemplate restTemplate;

    @Autowired
    public SegmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/segment")
    private String url;

    public List<Segment> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Segment>>() {
                }).getBody();
    }

    public Segment getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Segment>() {
                }).getBody();
    }

    public Segment create(Segment segment) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(segment),
                new ParameterizedTypeReference<Segment>() {
                }).getBody();
    }

    public Segment update(int id, Segment segment) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(segment),
                new ParameterizedTypeReference<Segment>() {
                }).getBody();
    }

    public Segment delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Segment>() {
                }).getBody();
    }
}
