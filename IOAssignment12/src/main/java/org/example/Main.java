package org.example;

import org.example.cvs.FileAthleteReader;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        FileAthleteReader reader=new FileAthleteReader();
        List<Athlete> athletes=reader.fileReader("src\\main\\resources\\competitionSpreadsheet.txt");

        System.out.println(athletes);


        sortAndDisplay(athletes);


    }

    private static void sortAndDisplay(List<Athlete> list){
        var comparator= new Comparator<Athlete>() {
            @Override
            public int compare(Athlete o1, Athlete o2) {
                return o1.getDuration().compareTo(o2.getDuration());
            }
        };
        Collections.sort(list,comparator);
        for (int i=0;i<list.size();i++) {
            int place=i+1;
            String placeString;
            switch (place){
                case 1->placeString="Winner";
                case 2->placeString="Runner-UP";
                case 3->placeString="Third Place";
                case 4->placeString="Fourth Place";
                case 5->placeString="Fifth Place";
                default ->placeString= "invalid place";
            }
            System.out.println( placeString + "\n"+list.get(i));
        }
    }





}