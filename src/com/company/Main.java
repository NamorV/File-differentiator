package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("tenor.txt");
        byte[] fileContent = Files.readAllBytes(file.toPath());
        Differentiator differentiator = new Differentiator();
        String name = file.getName();
        String extension = name.substring(name.lastIndexOf("."));
        differentiator.validate(fileContent, extension);
    }
}
