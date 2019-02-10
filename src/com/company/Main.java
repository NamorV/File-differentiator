package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader();
        Differentiator differentiator = new Differentiator();
        fileReader.getFileByName("a.txt");

        differentiator.validate(fileReader.getFileContent(), fileReader.getExtension());
    }
}
