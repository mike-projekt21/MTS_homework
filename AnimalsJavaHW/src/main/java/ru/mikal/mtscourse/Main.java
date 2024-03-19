package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.AbstractAnimal;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\duplicateTests\\data_duplicatePositive.txt"), StandardCharsets.UTF_8);
        Zoo zoo1 = new Zoo();
        zoo1.fillZoo(myFile);
//        zoo1.printZoo();
//        System.out.println(zoo1.findDuplicate());
        for (AbstractAnimal animal : zoo1.findDuplicate()) {
            System.out.println(animal.toString());
        }

    }
}