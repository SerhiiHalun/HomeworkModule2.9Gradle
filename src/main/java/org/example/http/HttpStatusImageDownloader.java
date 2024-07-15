package org.example.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code){
        String URL_path = new HttpStatusChecker().getStatusImage(code);
        try {
            HttpClient client = HttpClient.newHttpClient();
            URI URI_WEB_SITE = new URI(URL_path);
            HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI_WEB_SITE).GET().build();
            HttpResponse<byte[]> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofByteArray());
            File image = new File("image"+code+".jpg");
            if (image.createNewFile()){
                try (FileOutputStream fos = new FileOutputStream(image)) {
                    fos.write(response.body());
                    System.out.println("File created: " + image.getName());
                }
            }

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
