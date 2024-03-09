package ru.mikal.mtscourse.childClasses;

import java.time.LocalDate;
/**
 * Класс волк. Наследуется от {@link Predator}
 */
public class Wolf extends Predator{
    public Wolf(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
}
