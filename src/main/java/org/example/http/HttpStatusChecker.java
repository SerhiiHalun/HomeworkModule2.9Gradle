package org.example.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private final String URL_WEB_SITE = "https://http.cat";

    public String  getStatusImage(int code){

        String URL_path = URL_WEB_SITE+"/"+code+".jpg";
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI URI_WEB_SITE = new URI(URL_path);
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI_WEB_SITE).GET().build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 404){
                throw new RuntimeException("Not found this status code");
            }

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return URL_path;
    }
}
