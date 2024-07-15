package org.example.http;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private final String URL_WEB_SITE = "https://http.cat";
    public void askStatus(){
        System.out.println("Enter HTTP status code");
        Scanner scanner = new Scanner(System.in);
        int code = scanner.nextInt();
        try{
            HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
            httpStatusImageDownloader.downloadStatusImage(code);
        }catch (RuntimeException e){
            System.out.println("Please enter valid number");
        }




    }
}
