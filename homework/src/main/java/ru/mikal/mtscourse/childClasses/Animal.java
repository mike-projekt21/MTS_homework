package ru.mikal.mtscourse.childClasses;

import java.time.LocalDate;
/**
 * Интерфейс с геттерами для полей класса {@link AbstractAnimal}
 */
public interface Animal {
    /**
     * Функция получения значения поля {@link AbstractAnimal#breed}
     * @return возвращает породу животного
     */
    public String getBreed();

    /**
     * Функция получения значения поля {@link AbstractAnimal#name}
     * @return возвращает имя животного
     */
    public String getName();

    /**
     * Функция получения значения поля {@link AbstractAnimal#cost}
     * @return возвращает стоимость животного
     */
    public double getCost();

    /**
     * Функция получения значения поля {@link AbstractAnimal#character}
     * @return возвращает характер животного
     */
    public String getCharacter();

    /**
     * Функция получения значения поля {@link AbstractAnimal#birthDate}
     * @return возвращает день рождения животного
     */
    public LocalDate getBirthDate();
}
