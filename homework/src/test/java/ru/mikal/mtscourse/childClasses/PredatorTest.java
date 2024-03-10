package ru.mikal.mtscourse.childClasses;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PredatorTest {

    @Test
    @DisplayName("Положительный сценарий")
    void equalsPositive(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
        Predator animal2 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
        Assertions.assertTrue(animal1.equals(animal2));
    }
    @Test
    @DisplayName("Проверка равенства одного и того же объекта")
    void equalsSame(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
        Predator animal3 = animal1;
        Assertions.assertTrue(animal1.equals(animal3));
    }
    @Test
    @DisplayName("Сравнение с null")
    void equalsNull(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
        Predator animal2 = null;
        Assertions.assertFalse(animal1.equals(animal2));
    }
    @Test
    @DisplayName("Сравнение объектов дочернего и родительского классов")
    void equalsParentClass(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
        Predator animal2 = new Predator("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));;
        Assertions.assertFalse(animal1.equals(animal2));
    }
    @Nested
    @DisplayName("Несовпадение полей ")
    class DifferentFields {
        @Test
        @DisplayName("Несовпадение классов")
        void equalsClass(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Predator animal2 = new Shark("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Assertions.assertFalse(animal1.equals(animal2));
        }
        @Test
        @DisplayName("Несовпадение породы")
        void equalsBreed(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Predator animal2 = new Wolf("basic", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Assertions.assertFalse(animal1.equals(animal2));
        }
        @Test
        @DisplayName("Несовпадение имён")
        void equalsName(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Predator animal2 = new Wolf("grey", "Hazy", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Assertions.assertFalse(animal1.equals(animal2));
        }
        @Test
        @DisplayName("Несовпадение стоимости")
        void equalsCost(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Predator animal2 = new Wolf("grey", "Charly", Double.parseDouble("100.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Assertions.assertFalse(animal1.equals(animal2));
        }
        @Test
        @DisplayName("Несовпадение характера")
        void equalsCharacter(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Predator animal2 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Silly", LocalDate.parse("2000-05-11", formatter));
            Assertions.assertFalse(animal1.equals(animal2));
        }
        @Test
        @DisplayName("Несовпадение даты рождения")
        void equalsBirthday(){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Predator animal1 = new Wolf("grey", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-05-11", formatter));
            Predator animal2 = new Wolf("basic", "Charly", Double.parseDouble("1000.5"), "Angry", LocalDate.parse("2000-06-11", formatter));
            Assertions.assertFalse(animal1.equals(animal2));
        }
    }

}
