package org.example.cvs;

import org.example.Athlete;
import org.jetbrains.annotations.NotNull;

import java.awt.print.Book;
import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FileAthleteReader{
    public List<Athlete> fileReader(String fileName) throws IOException {

        List<Athlete> athletes =new ArrayList<>();

        BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName));
        String line;

        while ((line = bufferedReader.readLine()) !=null){
            athletes.add(extracted( line));
        }
        if (bufferedReader !=null){
            bufferedReader.close();
        }

        return athletes;
    }

    public static Athlete extracted( String line) {
        String[] tokens= line.split(",");
        String[] timeParts=tokens[3].split(":");
        int minutes=Integer.parseInt(timeParts[0]);
        int seconds=Integer.parseInt(timeParts[1]);
        String[] shootingResults=tokens[4].split(";");
        char[][] shootingRangeResults=new char[shootingResults.length][];
        for (int i=0;i<shootingResults.length;i++){
            shootingRangeResults[i]=shootingResults[i].toCharArray();
        }
        Athlete athlete=new Athlete(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2],
                Duration.ofMinutes(minutes).plusSeconds(seconds),
                shootingRangeResults
        );
        return athlete;
    }

}

