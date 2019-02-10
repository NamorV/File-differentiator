package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        Differentiator differentiator = new Differentiator();

        System.out.println("Type file name or q to exit.");

        while(true) {
            String line = scanner.nextLine();

            if(line.equals("q")) {
                System.exit(0);
            }

            try {
                fileReader.getFileByName(line);
                differentiator.validate(fileReader.getFileContent(), fileReader.getExtension());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                continue;
            }
        }
    }
}
