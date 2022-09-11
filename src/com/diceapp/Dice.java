package com.diceapp;

import java.io.*;
import java.util.*;

public class Dice {

    public static void createFile() {
        // En String som vi skall ha 1000 nr i, använder StringBuilder för detta.
        StringBuilder numbers = new StringBuilder();
        int count = 0;

        // Random Klassen för skapande av 1-6 random nr.
        Random rand = new Random();

        // Loopar genom numbersArray och lägger in 1000 random tal.
        for (int i = 0; i < 1000; i++) {
            numbers.append(rand.nextInt(1, 7));
            count++;
        }

        // Filhantering
        String fileName = "numbers.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(numbers.toString());
            writer.close();
            System.out.println("Successfully wrote " + count + " numbers to " + fileName);
        } catch (IOException error) {
            error.printStackTrace();
        }

    }

    public static int[] createArray() {
        // Försökte hålla den dynamisk av numbers.length() men fick problem med scope och returns
        int[] numbersArray = new int[1000];

        //Filhantering
        try {
            String fileName = "numbers.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String numbers = reader.readLine();

            for (int i = 0; i < numbers.length(); i++) {
                String varvetsTal = String.valueOf(numbers.charAt(i));
                int currenNumber = Integer.parseInt(varvetsTal); // Konverterar varvets char till int
                numbersArray[i] = currenNumber; // Assign talet till int Array
            }
            reader.close();

        } catch (IOException error) {
            error.printStackTrace();
        }
        return numbersArray;
    }


    public static HashMap<Integer, Integer> analyzeArray(int[] array) {
        HashMap<Integer, Integer> amountOfNumbersInArray = new HashMap<>(Map.of(
                1, 0,
                2, 0,
                3, 0,
                4, 0,
                5, 0,
                6, 0));

        for (int number : array) {
            // int currentValue = amountOfNumbersInArray.get(number) == null ? 0 : amountOfNumbersInArray.get(number); // NULL CHECK (ternary operator) PGA FÖRSTA GÅNGEN INGET VÄRDE, sätter 0 i value annars get(key) == value

            int currentValueOfKey = amountOfNumbersInArray.get(number);
            // Ökar på count för varje gång den stöter på en siffra för Map value
            amountOfNumbersInArray.put(number, currentValueOfKey + 1);  // Dynamiskt letar i filen hur många siffror (KEY) och mappar till VALUE, första gången SKAPAR sedan UPPDATERAR mha count variabel, pga KEY redan finns
        }


        return amountOfNumbersInArray;
    }

    public static int[] analyzeArrayReturnArray(int[] array) {
        int[] analyzedArray = new int[6];

        for (int i = 0; i < array.length; i++) {
            int currentNr = array[i];

            switch (currentNr) {
                case 1 -> analyzedArray[0] += 1;
                case 2 -> analyzedArray[1] += 1;
                case 3 -> analyzedArray[2] += 1;
                case 4 -> analyzedArray[3] += 1;
                case 5 -> analyzedArray[4] += 1;
                default -> analyzedArray[5] += 1; // 6or
            }
        }

        return analyzedArray;
    }

    public static void printArray(int[] array) {
        System.out.println("MED ARRAY LÖSNING IST FÖR HASHMAP\n");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+1 + "or antal: " + array[i] );
        }
    }


    public static void printAnalyzedArrayAsMap(HashMap<Integer, Integer> antalSiffror) {
        for (int siffra : antalSiffror.keySet()) { // bara 1-6 på Keys i Map
            System.out.println(antalSiffror.get(siffra) + " st " + siffra + "or"); // Hämtar VALUE med KEY och Skriver ut I terminalen
        }
    }


    public static void writeResultToTextFile(HashMap<Integer, Integer> antalSiffror) {
        String fileName = "result.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (int siffra : antalSiffror.keySet()) { // bara 1-6 på Keys i HashMap
                writer.write(antalSiffror.get(siffra).toString() + " st " + siffra + "or"); // Hämtar VALUE med KEY och Skriver ut I terminalen
                writer.write("\n");
            }

            writer.close();
            System.out.println("Successfully wrote result in: " + fileName);

        } catch (IOException error) {
            error.printStackTrace();
        }
    }


    // (Extra för skoj) Dynamisk funktion med generics wildcard <?>, som printar vilken typ av HM som helst samt en INT array.
    public static void printer(HashMap<?, ?> hashMap, int[] array) {
        printArray(array);
        System.out.println("\n----------------\n");
        hashMap.forEach( (key, value) -> System.out.println(hashMap.get(key) + " st " + key + "or")); // lambda Test
    }


}
