package com.diceapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAnalyzer {

    public static void getAmountOfLettersInFile() {
        try {
            Scanner scan = new Scanner(new File("result.txt"));
            StringBuilder sb = new StringBuilder();

            while(scan.hasNextLine()) {
                sb.append(scan.nextLine());
            }

            String withoutSpace = sb.toString().replaceAll(" ", "");

            System.out.println("\nAntal tecken med space inkluderat som \"tecken\": " + sb.length() + "st");
            System.out.println("\nAntal tecken: " + withoutSpace.length() + "st");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
