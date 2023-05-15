package id.co.mii.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.co.mii.project.models.Kelas;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;

@Service
public class KelasService {
    private RestTemplate restTemplate;

    @Autowired
    public KelasService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.baseUrl}/kelas")
    private String url;

    public List<Kelas> getAll() {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Kelas>>() {
                }).getBody();
    }

    public Kelas getById(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Kelas>() {
                }).getBody();
    }

    public Kelas create(Kelas kelas) {
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                new HttpEntity(kelas),
                new ParameterizedTypeReference<Kelas>() {
                }).getBody();
    }

    public Kelas update(int id, Kelas kelas) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.PUT,
                new HttpEntity(kelas),
                new ParameterizedTypeReference<Kelas>() {
                }).getBody();
    }

    public Kelas delete(int id) {
        return restTemplate.exchange(
                url + "/" + id,
                HttpMethod.DELETE,
                null,
                new ParameterizedTypeReference<Kelas>() {
                }).getBody();
    }
}
