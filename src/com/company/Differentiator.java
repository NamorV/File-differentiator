package com.company;

import java.util.Arrays;

public class Differentiator {
    private static final byte[] JPG_MAGIC_NUMBER = {(byte) 0xFF, (byte) 0xD8, (byte) 0xFF};
    private static final byte[] GIF_MAGIC_NUMBER1 = {(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38,
            (byte) 0x39, (byte) 0x61};
    private static final byte[] GIF_MAGIC_NUMBER2 = {(byte) 0x47, (byte) 0x49, (byte) 0x46, (byte) 0x38,
            (byte) 0x37, (byte) 0x61};
    private static String JPG_EXTENSION = ".jpg";
    private static String GIF_EXTENSION = ".gif";
    private static String TXT_EXTENSION = ".txt";

    public void validate(byte[] fileContent, String extension) {

        if(!extension.equals(JPG_EXTENSION) && !extension.equals(GIF_EXTENSION) && !extension.equals(TXT_EXTENSION)) {
            throw new WrongExtensionException("This program don't handle such extension!");
        }

        if(isJPG(fileContent)) {
            validateExtension(extension, JPG_EXTENSION);
        } else if(isGIF(fileContent)) {
            validateExtension(extension, GIF_EXTENSION);
        } else {
            validateExtension(extension, TXT_EXTENSION); //files with txt don't have magic numbers
        }
    }

    private boolean isJPG(byte[] fileContent) {
        byte[] actualMagicNumber = new byte[JPG_MAGIC_NUMBER.length];

        for(int i = 0; i < JPG_MAGIC_NUMBER.length; i++) {
            actualMagicNumber[i] = fileContent[i];
        }

        if(Arrays.equals(actualMagicNumber, JPG_MAGIC_NUMBER)) {
            return true;
        }

        return false;
    }

    private boolean isGIF(byte[] fileContent) {
        byte[] actualMagicNumber = new byte[GIF_MAGIC_NUMBER1.length];

        for(int i = 0; i < GIF_MAGIC_NUMBER1.length; i++) {
            actualMagicNumber[i] = fileContent[i];
        }

        if((Arrays.equals(actualMagicNumber, GIF_MAGIC_NUMBER1)) ||
                (Arrays.equals(actualMagicNumber, GIF_MAGIC_NUMBER2))) {
            return true;
        }

        return false;
    }

    private void validateExtension(String currentExtension, String realExtension) {
        if(currentExtension.equals(realExtension)) {
            System.out.println("Yes, this is " + currentExtension + " file.");
        } else {
            throw new WrongExtensionException("Extension is " + currentExtension +
                                                ", while actually it's a " + realExtension);
        }
    }
}
