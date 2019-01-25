package com.sim;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandling {
    
    public String[][] getPersonsData(String filename) {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lineCount = getLineCount(filename);
            String[][] persons = new String[lineCount][2];
            for (int i=0; i < lineCount; i++) {
                persons[i] = reader.readLine().split(",");
            }
            return persons;
        } catch (FileNotFoundException F) {
            System.out.println("File not found!");
            return null;
        } catch (IOException E) {
            System.out.println("File not readable!");
            return null;
        }
    }

    private int getLineCount(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lines = 0;
            while (reader.readLine() != null) lines++;
            return lines;
        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return 0;
        } catch (IOException i) {
            System.out.println("File not readable!");
            return 0;
        }
    }
}