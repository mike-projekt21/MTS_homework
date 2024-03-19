package ru.mikal.mtscourse.childClasses;
import java.time.LocalDate;
/**
 * Класс кошка. Наследуется от {@link Pet}
 */
public class Cat extends Pet{
    public Cat(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
