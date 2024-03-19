package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.*;

import java.time.LocalDate;
/**
 * Фабричный класс для создания объектов классов {@link Cat} и {@link Dog}, наследников класса {@link Pet}.
 * Сам класс наследуется от {@link AnimalFactory}
 */
public class PetFactory extends AnimalFactory{
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
     * @return возвращает объект класса {@link Cat} или {@link Dog}
     *          по default сценарию вернёт null
     */
    @Override
    public Pet createAnimal (String [] animalData) {
        Pet animal = switch (animalData[1]) {
            case "Cat" -> new Cat(animalData[2],
                    animalData[3],
                    Double.parseDouble(animalData[4]),
                    animalData[5],
                    LocalDate.of(Integer.parseInt(animalData[6].split("-")[0]),
                            Integer.parseInt(animalData[6].split("-")[1]),
                            Integer.parseInt(animalData[6].split("-")[2])
                    ));
            case "Dog" -> new Dog(animalData[2],
                    animalData[3],
                    Double.parseDouble(animalData[4]),
                    animalData[5],
                    LocalDate.of(Integer.parseInt(animalData[6].split("-")[0]),
                            Integer.parseInt(animalData[6].split("-")[1]),
                            Integer.parseInt(animalData[6].split("-")[2])
                    ));
            default -> null;
        };
        return animal;
    }
}
