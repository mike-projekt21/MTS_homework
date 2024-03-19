package ru.mikal.mtscourse;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mikal.mtscourse.childClasses.AbstractAnimal;
import ru.mikal.mtscourse.childClasses.Pet;

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
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\leapYearTests\\data_leapYearPositive.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertLinesMatch(testZoo.findLeapYearNames(), expectedResult);
        }
        @Test
        @DisplayName("Нет животных с високосным годом")
        void noLeapYearAnimal() throws IOException {
            List<String> expectedResult = new ArrayList<>();

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\leapYearTests\\data_noLeapYearAnimal.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertLinesMatch(testZoo.findLeapYearNames(), expectedResult);
        }
        @Test
        @DisplayName("Пустой массив на вход")
        void emptyArrayInput() throws IOException {
            List<String> expectedResult = new ArrayList<>();

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\leapYearTests\\data_emptyArrayInput.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertLinesMatch(testZoo.findLeapYearNames(), expectedResult);
        }
        @Test
        @DisplayName("Год рождения из будущего")
        void futureLeapYear() throws IOException {
            List<String> expectedResult = new ArrayList<>();
            expectedResult.add("Charly");
            expectedResult.add("Olof");

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\leapYearTests\\data_futureLeapYear.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertLinesMatch(testZoo.findLeapYearNames(), expectedResult);
        }
        @Test
        @DisplayName("Нулевая дата рождения 00-00-0000")
        void zeroBirthDay() throws IOException {
            List<String> expectedResult = new ArrayList<>();
            expectedResult.add("Charly");
            expectedResult.add("Olof");
            expectedResult.add("Jager");

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\leapYearTests\\data_zeroBirthDay.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertLinesMatch(testZoo.findLeapYearNames(), expectedResult);
        }
    }

    @Nested
    @DisplayName("Поиск животных старше n лет")
    class FindOlderAnimal {
        //я в этом тесте проверил не только положительный сцйенарий, но и посмотрел граничные точки.
        // В момент проверки дата 10.03.2024. Соответственно граничные значения для n = 4 2019-03-10, 2019-03-09, 2019-03-11
        @ParameterizedTest
        @ValueSource(ints = {4})
        @DisplayName("Положительный сценарий")
        void leapYearPositive(int argument) throws IOException {
            List<AbstractAnimal> expectedResult = new ArrayList<>();
            PredatorFactory predatorFactory = new PredatorFactory();
            PetFactory petFactory = new PetFactory();
            expectedResult.add(predatorFactory.createAnimal("Predator Wolf grey Charly 1000.5 Angry 2019-03-10".split(" ")));
            expectedResult.add(predatorFactory.createAnimal("Predator Wolf grey Olof 1000.5 Angry 2004-05-11".split(" ")));
            expectedResult.add(petFactory.createAnimal("Pet Dog Hasky Andy 572.0 Silly 2019-03-09".split(" ")));

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\olderAnimalTests\\data_olderAnimalPositive.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertEquals(expectedResult, testZoo.findOlderAnimal(argument));
        }
    }

    @Nested
    @DisplayName("Поиск дубликатов")
    class FindDuplicate {
        @Test
        @DisplayName("Положительный сценарий")
        void duplicatePositive() throws IOException {
            List<AbstractAnimal> expectedResult = new ArrayList<>();
            PredatorFactory predatorFactory = new PredatorFactory();
            PetFactory petFactory = new PetFactory();
            expectedResult.add(predatorFactory.createAnimal("Predator, Wolf, grey, Charly, 1000.5, Angry, 2000-05-11".split(", ")));
            expectedResult.add(petFactory.createAnimal("Pet, Dog, Hasky, Jager, 572, Silly, 2016-08-25".split(", ")));

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\duplicateTests\\data_duplicatePositive.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertEquals(expectedResult, testZoo.findDuplicate());
        }
        @Test
        @DisplayName("Нет дубликатов")
        void noDuplicate() throws IOException {
            List<AbstractAnimal> expectedResult = new ArrayList<>();

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\duplicateTests\\data_noDuplicate.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertEquals(expectedResult, testZoo.findDuplicate());
        }
        @Test
        @DisplayName("Дубликаты null")
        void nullDuplicate() throws IOException {
            List<AbstractAnimal> expectedResult = new ArrayList<>();
            PredatorFactory predatorFactory = new PredatorFactory();
            expectedResult.add(predatorFactory.createAnimal("Predator Wolf grey Charly 1000.5 Angry 2019-03-10".split(" ")));
            expectedResult.add(null);

            Zoo testZoo = new Zoo();
            List<String> myFile = Files.readAllLines(Paths.get("D:\\Idea_Projects\\test\\homework\\src\\test\\resources\\duplicateTests\\data_noDuplicate.txt"), StandardCharsets.UTF_8);
            testZoo.fillZoo(myFile);

            Assertions.assertEquals(expectedResult, testZoo.findDuplicate());
        }
    }
}
