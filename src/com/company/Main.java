package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("a.jpg");
        System.out.println(file.toString());

        byte[] fileContent = Files.readAllBytes(file.toPath());
        System.out.println(fileContent);
    }
}
