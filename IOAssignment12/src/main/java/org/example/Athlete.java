package org.example;

import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.Arrays;


public class Athlete{

    public enum CountryCode{
        UK,
        CZ,
        RO,
        IT,
        USA,
        FR,
        INTERNATIONAL
    }

    private  int athleteNumber;
    private  String athleteName;
    private  CountryCode countryCode;
    private  Duration duration;
    private  char[][] shootingRangeResults= new char[3][5];

    public Athlete(int athleteNumber,@NotNull String athleteName, @NotNull String countryName, Duration duration, char[][] shootingRangeResults) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = switch (countryName){
            case "United Kingdom" -> CountryCode.UK;
            case "Czech Republic" -> CountryCode.CZ;
            case "Romania" -> CountryCode.RO;
            case "Italy" -> CountryCode.IT;
            case "USA" -> CountryCode.USA;
            case "France" -> CountryCode.FR;
            default -> CountryCode.INTERNATIONAL;
        };
        this.duration=duration;
        int count=0;
        for (char[] batch :shootingRangeResults){
            for (char result:batch){
                if (result=='o'){
                    Duration penalty= Duration.ofSeconds(10*(++count));
                    this.duration=duration.plus(penalty);
                }
            }
        }
        this.shootingRangeResults = shootingRangeResults;
    }

    @Override
    public String toString() {
        return athleteNumber + " "+
                " " +athleteName +" "
                + countryCode +
                ", duration=" + duration +
                ", shootingRangeResults=" + Arrays.deepToString(shootingRangeResults);
    }


    public Duration getDuration() {
        return duration;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }
}
