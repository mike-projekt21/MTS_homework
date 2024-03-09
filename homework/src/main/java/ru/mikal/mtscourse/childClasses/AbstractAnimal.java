package ru.mikal.mtscourse.childClasses;
import java.time.LocalDate;
/**
 * Абстрактный класс с основными харрактеристиками животного.
 * Включает в себя 5 полей и переопределённый конструктор.
 * Имплементирует интерфейс {@link Animal}, с пятью геттерами для каждого поля этого класса
 */
public abstract class AbstractAnimal implements Animal {
    protected String breed; // порода
    protected String name; // имя
    protected Double cost; // цена в магазине
    protected String character; // характер
    protected LocalDate birthDate; // День рождения животного в формате dd-MM-yyyy

    /**
     * Конструктор - создание нового объекта
     */
    public AbstractAnimal(String breed,
                          String name,
                          Double cost,
                          String character,
                          LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

}
