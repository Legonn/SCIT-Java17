package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFile = "src\\main\\resources\\inputData.txt";
        personListFilteredByBirthday(inputFile, 5, "outputData");


    }


    public static void personListFilteredByBirthday(String inputFile, int targetedMonth, String outputFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\main\\resources\\" + outputFile + ".txt"));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile))) {
            Map<LocalDate, List<String>> map = new HashMap<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                customRead(map, line);
            }
            var personList = map.entrySet().stream()
                    .filter(s -> s.getKey().getMonthValue() == targetedMonth)
                    .map(Map.Entry::getValue)
                    .map(sublist -> String.join(" ", sublist))
                    .sorted(Comparator.naturalOrder())
                    .toList();

            personList.forEach(s -> {
                try {
                    bufferedWriter.write(s + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void customRead(Map<LocalDate, List<String>> map, String line) {
        String[] tokens = line.split(" ");
        String[] timeParts = tokens[2].split("/");
        LocalDate birthDay = LocalDate.of(Integer.parseInt(timeParts[2])
                , Integer.parseInt(timeParts[1]), Integer.parseInt(timeParts[0]));
        map.put(birthDay, List.of(tokens[0], tokens[1]));
    }

}