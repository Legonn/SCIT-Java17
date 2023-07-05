package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void main_parseMetricDistance_valueIs0() {
        String component="0mm";
        assertEquals(0,Main.parseMetricDistance(component));
    }

    @Test
    public void main_parseMetricDistance_invalidScale() {
        String component="0mmcc";
        assertEquals(0,Main.parseMetricDistance(component));
    }

    @Test
    public void main_parseMetricDistance_emptyComponent() {
        String component="";
        assertEquals(0,Main.parseMetricDistance(component));
    }

    @Test
    public void main_calculator_properValues(){
        String calculus="10mm-10mm+10mm";
        String result=Main.calculator(calculus);
        assertEquals("10 mm",result);
    }

    @Test
    public void main_calculator_oneOperand(){
        String calculus="10mm";
        String result=Main.calculator(calculus);
        assertEquals("10 mm",result);
    }


}