package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.*;

import java.time.LocalDate;

public class PredatorFactory extends AnimalFactory{
    @Override
    public Predator createAnimal (String [] animalData) {
        Predator animal = switch (animalData[1]) {
            case "Wolf" -> new Wolf(animalData[2],
                    animalData[3],
                    Double.parseDouble(animalData[4]),
                    animalData[5],
                    LocalDate.of(Integer.parseInt(animalData[6].split("-")[0]),
                            Integer.parseInt(animalData[6].split("-")[1]),
                            Integer.parseInt(animalData[6].split("-")[2])
                    ));
            case "Shark" -> new Shark(animalData[2],
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
