package org.example.cvs;

import org.example.Athlete;
import org.junit.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileAthleteReaderTest {


    @Test
    public void parsingMethodTest_checkingIfTheAthleteAttributesAreParsedAppropriately(){
        FileAthleteReader reader =new FileAthleteReader();
        String line = "11,Umar Jorgson,Italy,30:27,xxxox;xxxxx;xxoxo";

        Athlete athlete=FileAthleteReader.extracted(line);
        assertEquals("Umar Jorgson",athlete.getAthleteName());
    }

    @Test
    public void parsingMethodTest_checkingIfTheTimeResultsAreCalculatedAppropriately(){
        FileAthleteReader reader =new FileAthleteReader();
        String line = "10,George Smith,USA,30:30,xxxxx;xxxxx;xxxxx";

        //Time result should be the same since his shooting range is perfect(no "o", only "x")
        Athlete athlete=FileAthleteReader.extracted(line);
        assertEquals(Duration.ofMinutes(30).plusSeconds(30),athlete.getDuration());
    }


}