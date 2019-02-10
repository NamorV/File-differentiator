package com.company;

import java.util.Arrays;

public class Differentiator {

    private static final byte[] JPG_MAGIC_NUMBER = {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF};
    private static final byte[] GIF_MAGIC_NUMBER1 = {(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38,
            (byte) 0x39, (byte) 0x61};
    private static final byte[] GIF_MAGIC_NUMBER2 = {(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38,
            (byte) 0x37, (byte) 0x61};

    public void validate(byte[] fileContent) {
        byte[] actualMagicNumber = new byte[JPG_MAGIC_NUMBER.length];

        for(int i = 0; i < JPG_MAGIC_NUMBER.length; i++) {
            actualMagicNumber[i] = fileContent[i];
        }

        if(Arrays.equals(actualMagicNumber, JPG_MAGIC_NUMBER)) {
            System.out.println("Its JPG!");
        }

        actualMagicNumber = new byte[GIF_MAGIC_NUMBER1.length];

        for(int i = 0; i < GIF_MAGIC_NUMBER1.length; i++) {
            actualMagicNumber[i] = fileContent[i];
        }

        if((Arrays.equals(actualMagicNumber, GIF_MAGIC_NUMBER1)) ||
                (Arrays.equals(actualMagicNumber, GIF_MAGIC_NUMBER2))) {
            System.out.println("Its GIF!");
        }
    }
}
