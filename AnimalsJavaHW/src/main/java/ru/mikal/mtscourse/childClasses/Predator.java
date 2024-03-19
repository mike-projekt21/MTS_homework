package ru.mikal.mtscourse.childClasses;
import java.time.LocalDate;
/**
 * Класс - один из двух подвклассов животных. Наследуется от {@link AbstractAnimal}.
 * Новых полей не добавляется, конструктор как в родителе.
 * Переопределён метод equals и toString.
 * Написанна реализация для кадждого геттера из родительского класса
 */
public class Predator extends AbstractAnimal {
    public Predator(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }
    /**
     * Функция получения значения поля {@link Predator#breed}
     * @return возвращает породу животного
     */
    @Override
    public String getBreed() {
        return this.breed;
    }

    /**
     * Функция получения значения поля {@link Predator#name}
     * @return возвращает имя животного
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Функция получения значения поля {@link Predator#cost}
     * @return возвращает стоимость животного
     */
    @Override
    public double getCost() {
        return this.cost;
    }

    /**
     * Функция получения значения поля {@link Predator#character}
     * @return возвращает характер животного
     */
    @Override
    public String getCharacter() {
        return this.character;
    }

    /**
     * Функция получения значения поля {@link Predator#birthDate}
     * @return возвращает день рождения животного
     */
    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    /**
     * Функция проверки равенства двух объектов
     * @param obj объект для сравнения
     * @return возвращает True в случае совпадения классов объектов и совпадения значений всех полей
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Predator animal = (Predator) obj;
        return (this.breed.equals(animal.getBreed()) &&
                this.name.equals(animal.getName()) &&
                this.cost == animal.getCost() &&
                this.character.equals(animal.getCharacter()) &&
                this.birthDate.equals(animal.getBirthDate()));
    }
    /**
     * Функция преобразования в строку объекта класса Predator
     * @return возвращает строку из всех полей через пробел
     */
    @Override
    public String toString() {
        return "" + this.getClass() + " " + this.breed + " " + this.name + " " + this.cost + " " + this.character + " " + this.birthDate;
    }
}
