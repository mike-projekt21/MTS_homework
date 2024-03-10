package ru.mikal.mtscourse.childClasses;
import java.time.LocalDate;
/**
 * Класс - один из двух подвклассов животных. Харрактеризует виды домашних животных. Наследуется от {@link AbstractAnimal}.
 * Новых полей не добавляется, конструктор как в родителе.
 * Переопределён метод equals и toString.
 * Написанна реализация для кадждого геттера из родительского класса
 *
 * Ничем не отличается от класса {@link Predator}
 * Документацию к методам см. там
 */
public class Pet extends AbstractAnimal {
    public Pet(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String getCharacter() {
        return this.character;
    }

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
        Pet animal = (Pet) obj;
        return (this.breed.equals(animal.getBreed()) &&
                this.name.equals(animal.getName()) &&
                this.cost == animal.getCost() &&
                this.character.equals(animal.getCharacter()) &&
                this.birthDate.equals(animal.getBirthDate()));
    }
    public String toString() {
        return "" + this.getClass() + " " + this.breed + " " + this.name + " " + this.cost + " " + this.character + " " + this.birthDate;
    }
}
