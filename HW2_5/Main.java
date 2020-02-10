// WordCount Program
// Created by Yuning Zhou on 02/10/2020
// Big Data Analysis Homework 2 Part 5

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        // input
        // read file
        ArrayList<String> store = new ArrayList<String>();
        String[] searchWords = {"hackathon", "Dec", "Chicago", "Java"};
        HashMap<String, Integer> count = new HashMap<String, Integer>();

        try {
            File file = new File("./input.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNext()){
                store.add(reader.nextLine().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        // loop through each search word and see if any line contains it
        for (String a : searchWords) {
            count.put(a, 0);
            for (String b : store) {
                if (b.contains(a.toLowerCase())) {
                    count.put(a, count.get(a) + 1);
                }
            }
        }

        // output
        for (String i : count.keySet()) {
            System.out.println(i + " " + count.get(i));
        }

    }
}
