package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.*;

import java.time.LocalDate;

public class PredatorFactory extends AnimalFactory{
    @Override
    public Predator createAnimal (String [] animalData) {
        Predator animal = null;

        switch (animalData[1]) {
            case "Wolf":
                animal = new Wolf(animalData[2],
                        animalData[3],
                        Double.parseDouble(animalData[4]),
                        animalData[5],
                        LocalDate.of(Integer.parseInt(animalData[6].split("-")[0]),
                                Integer.parseInt(animalData[6].split("-")[1]),
                                Integer.parseInt(animalData[6].split("-")[2])
                        ));
                break;
            case "Shark":
                animal = new Shark(animalData[2],
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
