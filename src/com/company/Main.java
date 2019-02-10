package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class Main {
    private static final byte[] JPG_MAGIC_NUMBER = {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF};

    public static void main(String[] args) throws IOException {
        File file = new File("a.jpg");
        byte[] fileContent = Files.readAllBytes(file.toPath());

        byte[] actualMagicNumber = new byte[JPG_MAGIC_NUMBER.length];

        for(int i = 0; i < JPG_MAGIC_NUMBER.length; i++) {
            actualMagicNumber[i] = fileContent[i];
        }

        if(Arrays.equals(actualMagicNumber, JPG_MAGIC_NUMBER)) {
            System.out.println("Its JPG!");
        }
    }
}
