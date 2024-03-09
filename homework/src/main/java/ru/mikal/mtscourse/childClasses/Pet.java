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

    public boolean equals(AbstractAnimal animal) {
        return (this.getClass() == animal.getClass() &&
                this.breed == animal.getBreed() &&
                this.name == animal.getName() &&
                this.cost == animal.getCost() &&
                this.character == animal.getCharacter() &&
                this.birthDate == animal.getBirthDate());
    }
    public String toString() {
        return "" + this.getClass() + " " + this.breed + " " + this.name + " " + this.cost + " " + this.character + " " + this.birthDate;
    }
}
