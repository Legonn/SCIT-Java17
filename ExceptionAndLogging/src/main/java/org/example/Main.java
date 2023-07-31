package org.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static FileHandler fh = null;

    public static void main(String[] args) throws IOException {
        fh = new FileHandler("src\\main\\resources\\exceptions.log");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.info("start main");

        List<Student> studentsRepository = new ArrayList<>();
        try {
            addStudent(studentsRepository, new Student("a",
                    "Tatar", LocalDate.of(1997, 3, 13), "Male", "1970335242"));
            addStudent(studentsRepository, new Student("Alex",
                    "Geo", LocalDate.of(1997, 3, 13), "Male", "1970334242"));
            addStudent(studentsRepository, new Student("Alex",
                    "Beo", LocalDate.of(1997, 3, 14), "Female", "1977334242"));
            addStudent(studentsRepository, new Student("Alex",
                    "Geo", LocalDate.of(1997, 3, 12), "Male", "1977334243"));
        } catch (ValidationException e) {
            logger.log(Level.WARNING, "One or more of the field members are invalid", e);
            System.out.println(e.getMessage());
        }
        try {
            printStudents(studentsRepository, "last name");
            System.out.println("_".repeat(90));
            printStudents(studentsRepository, "date of birth");
//                deleteStudentById(studentsRepository, "");
        } catch (MethodExceptions d) {
            logger.log(Level.SEVERE, "Parameter Fields shouldn't be blank", d);
            System.out.println(d.getMessage());
        }

        logger.info("end main");
    }

    public static void addStudent(List<Student> studentList, Student student) {
        if (studentList.stream().anyMatch(s -> s.getCnp() == student.getCnp())) {
            throw new MethodExceptions("Student is already in the repository");
        } else {
            studentList.add(student);
        }
    }

    public static void deleteStudentById(List<Student> studentList, String id) {
        if (id.isBlank()) {
            throw new MethodExceptions("ID field shouldn't be blank");
        } else {
            studentList.removeIf(s -> s.getCnp() == id);
        }
    }

    public static List<Student> retrieveStudentsBasedOnAge(List<Student> studentList, String age) {
        List<Student> retrievedList = new ArrayList<>();
        age = age.replaceAll("\\D", "");
        int ageAsInt = Integer.parseInt(age);
        if (age.isEmpty() || ageAsInt < 0) {
            throw new MethodExceptions("Age format is invalid");
        } else {
            for (Student item : studentList) {
                int studentAge = Period.between(item.getDateOfBirth(), LocalDate.now()).getYears();
                if (studentAge == ageAsInt) {
                    retrievedList.add(item);
                }
            }
            return retrievedList;
        }
    }

    public static void printStudents(List<Student> studentList, String input) {
        input = input.toUpperCase();

        if (input.isEmpty()) {
            throw new MethodExceptions("Input Is empty");
        } else if (input.startsWith("LAST")) {
            studentList.stream()
                    .sorted(Comparator.comparing(Student::getLastName)
                    ).forEach(System.out::println);
        } else if (input.startsWith("DATE")) {
            studentList.stream()
                    .sorted(Comparator.comparing(Student::getDateOfBirth)
                    ).forEach(System.out::println);
        }
    }

}