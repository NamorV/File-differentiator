package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("tenor.gif");
        byte[] fileContent = Files.readAllBytes(file.toPath());
        Differentiator differentiator = new Differentiator();

        differentiator.validate(fileContent);
    }
}
