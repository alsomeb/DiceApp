package com.diceapp;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    Dice.createFile(); // Genererar textfilen
        int[] numbers = Dice.createArray(); // Skapar array baserat på numbers.txt

        HashMap<Integer, Integer> amountOfNumbers = Dice.analyzeArray(numbers); // Analyserar stora array, bryter ner till hur många 1-6 det är mha HashMap

        Dice.printAnalyzedArrayAsMap(amountOfNumbers); // Skriver ut den Analys på terminalen

        Dice.writeResultToTextFile(amountOfNumbers); // Skriver resultatet av antal 1-6 till result.txt


        // Array LÖSNING ist för HashMap, föredrar en key-value lösning dock!
        int[] analyzedArray = Dice.analyzeArrayReturnArray(numbers);
        Dice.printArray(analyzedArray);

        // Antal tecken som finns i filen result.txt
        FileAnalyzer.getAmountOfLettersInFile();

    }
}
