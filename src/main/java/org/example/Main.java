package org.example;

import org.example.http.HttpImageStatusCli;
import org.example.http.HttpStatusChecker;
import org.example.http.HttpStatusImageDownloader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();

    }
}