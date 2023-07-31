package org.example;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    private Main main;


    @Test
    public void testIfTheFirstNameFieldIsBlank_ItThrowsAnException(){


        try {
            Student student=new Student("","Alex",
                    LocalDate.of(1997,03,13),"male","199327732");
        } catch (ValidationException e) {
            assertEquals("First name shouldn't be blank",e.getMessage());
        }

    }
    @Test
    public void testIfTheLastNameFieldIsBlank_ItThrowsAnException(){


        try {
            Student student=new Student("Alex","",
                    LocalDate.of(1997,03,13),"male","199327732");
        } catch (ValidationException e) {
            assertEquals("Last name shouldn't be blank",e.getMessage());
        }

    }

    @Test
    public void testIfDeleteStudentByIdMethod_ThrowsExceptionWhenInputIsBlank() throws ValidationException {
        List<Student> list=new ArrayList<>();
        Student student=new Student("Alex","Xela",
                LocalDate.of(1997,03,13),"male","199327732");
        Main.addStudent(list,student);
        try{
            Main.deleteStudentById(list,"");
        }catch (MethodExceptions e){
            assertEquals("ID field shouldn't be blank",e.getMessage());
        }

    }
}