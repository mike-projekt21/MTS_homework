package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.AbstractAnimal;
import ru.mikal.mtscourse.childClasses.Pet;
import ru.mikal.mtscourse.childClasses.Predator;

import java.time.LocalDate;
/**
 * Фабричный класс для создания объектов классов {@link Predator} и {@link Pet}, наследников абстракного класса {@link AbstractAnimal}.
 */
public class AnimalFactory {
    /**
     * Функция создания объекта одного из классов в зависимости от параметра
     * @param animalData массив строк следующего формата
     *        1)Подкласс животного "Predator" или "Pet"
     *        2)Подвид животного "Wolf", "Shark", "Cat", "Dog"
     *        3)Порода животного
     *        4)Имя животного
     *        5)Стоимость животного
     *        6)Характер животного
     *        7)День рождения животного в формате dd-MM-yyyy животного
     * @return возвращает объект класса {@link Predator} или {@link Pet}
     *          по default сценарию вернёт null
     */
    public AbstractAnimal createAnimal (String [] animalData) {
        AbstractAnimal animal = null;

        switch (animalData[0]) {
            case "Predator":
                animal = new Predator(animalData[2],
                        animalData[3],
                        Double.parseDouble(animalData[4]),
                        animalData[5],
                        LocalDate.of(Integer.parseInt(animalData[6].split("-")[0]),
                                Integer.parseInt(animalData[6].split("-")[1]),
                                Integer.parseInt(animalData[6].split("-")[2])
                        ));
                break;
            case "Pet":
                animal = new Pet(animalData[2],
                        animalData[3],
                        Double.parseDouble(animalData[4]),
                        animalData[5],
                        LocalDate.of(Integer.parseInt(animalData[6].split("-")[0]),
                                Integer.parseInt(animalData[6].split("-")[1]),
                                Integer.parseInt(animalData[6].split("-")[2])
                        ));
                break;
        }
        return animal;
    }
}
