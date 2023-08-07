package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MainTest {



    @Test
    public void testCustomReadMethod_WhenParsingALineItPutsOneElementIntoAMap(){
        Map<LocalDate, List<String>> map=new HashMap<>();
        String line="Jorge Gutierez 13/04/1983";

        Main.customRead(map,line);
        assertEquals(1,map.size());
    }

    @Test
    public void customReadMethod_testIfTheMapKeyIsEqualToTheBirthDay(){
        Map<LocalDate, List<String>> map=new HashMap<>();
        String line="Jorge Gutierez 13/04/1983";

        Main.customRead(map,line);
        LocalDate expectedDate=LocalDate.of(1983,04,13);
        assertTrue(map.containsKey(expectedDate));
    }

    @Test
    public void customReadMethod_testIfValueIsEqualToTheFullName(){
        Map<LocalDate, List<String>> map=new HashMap<>();
        String line="Jorge Gutierez 13/04/1983";

        Main.customRead(map,line);
        List<String> name=List.of("Jorge","Gutierez");
        LocalDate expectedDate=LocalDate.of(1983,04,13);
        assertEquals(name,map.get(expectedDate));
    }


}