package ru.mikal.mtscourse.childClasses;
import java.time.LocalDate;
/**
 * Класс собака. Наследуется от {@link Pet}
 */
public class Dog extends Pet{
    public Dog(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
