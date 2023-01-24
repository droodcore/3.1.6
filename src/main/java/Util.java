import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Util {

    private static final String url = "http://94.198.50.185:7081/api/users";
    private final RestTemplate restTemplate;
    private final HttpHeaders headers;

    public Util() {
        restTemplate = new RestTemplate();


        String headerString = restTemplate.headForHeaders(url, String.class)
                .get("Set-Cookie").get(0);


        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Cookie", headerString);

        System.out.println(headers);

    }


    public List getAll() {

        HttpEntity<String> entity = new HttpEntity<>("", headers);

        return restTemplate.exchange(url, HttpMethod.GET, entity, List.class).getBody();

    }

    public String save(User user) {


        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
    }

    public String patch(User user) {

        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
    }

    public String delete(int id) {

        HttpEntity<String> entity = new HttpEntity<>("", headers);

        return restTemplate.exchange(url + "/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
