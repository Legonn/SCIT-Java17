package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class MainTestParam {

    private final String input;
    private final String expectedResult;

    public MainTestParam(String input, String expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }


    @Parameterized.Parameters
    public static Collection operands(){
       return Arrays.asList(new Object[][]{
                {"10mm","10 mm"},{"10cm","100 mm"},
                {"10mm-15mm+20cm","195 mm"}
        });
    }

    @Test
    public void testMain(){
        System.out.println("Parameterized input is :"+input);
        assertEquals(expectedResult,Main.calculator(input));
    }

}