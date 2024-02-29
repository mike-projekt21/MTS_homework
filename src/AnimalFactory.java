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
                animal = new Predator(animalData[1],
                        animalData[2],
                        Double.parseDouble(animalData[3]),
                        animalData[4],
                        LocalDate.of(Integer.parseInt(animalData[5].split("-")[2]),
                                Integer.parseInt(animalData[5].split("-")[1]),
                                Integer.parseInt(animalData[5].split("-")[0])
                        ));
                break;
            case "Pet":
                animal = new Pet(animalData[1],
                        animalData[2],
                        Double.parseDouble(animalData[3]),
                        animalData[4],
                        LocalDate.of(Integer.parseInt(animalData[5].split("-")[2]),
                                Integer.parseInt(animalData[5].split("-")[1]),
                                Integer.parseInt(animalData[5].split("-")[0])
                        ));
                break;
        }
        return animal;
    }
}
