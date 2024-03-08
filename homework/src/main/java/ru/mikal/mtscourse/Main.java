package ru.mikal.mtscourse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\main\\resources\\animals_data.txt"), StandardCharsets.UTF_8);
        Zoo zoo1 = new Zoo();
        zoo1.fillZoo(myFile);
        zoo1.printZoo();
//        zoo1.findLeapYearNames();
    }
}