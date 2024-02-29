import childClasses.AbstractAnimal;
import childClasses.Pet;
import childClasses.Predator;
import childClasses.Wolf;

import java.time.LocalDate;

public class AnimalFactory {
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
