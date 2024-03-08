package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.*;

import java.time.LocalDate;

public class PetFactory extends AnimalFactory{
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
