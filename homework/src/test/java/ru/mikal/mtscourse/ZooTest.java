package ru.mikal.mtscourse;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ZooTest {

    @Nested
    @DisplayName("Поиск животных с високосным годом")
    class FindLeapYearNames {

        @Test
        @DisplayName("Положительный сценарий")
        void leapYearPositive() throws IOException {
            List<String> expectedResult = new ArrayList<>();
            expectedResult.add("Charly");
            expectedResult.add("Olof");
            expectedResult.add("Jager");

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\data_leapYearPositive.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertLinesMatch(testZoo.findLeapYearNames(), expectedResult);

        }
    }

    @Nested
    @DisplayName("Поиск животных старше n лет")
    class FindOlderAnimal {

        @Test
        @DisplayName("Положительный сценарий")
        void leapYearPositive() throws IOException {
            List<String> expectedResult = new ArrayList<>();
            expectedResult.add("Charly");
            expectedResult.add("Olof");
            expectedResult.add("Jager");

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\data_leapYearPositive.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertLinesMatch(testZoo.findLeapYearNames(), expectedResult);

        }
    }
}
