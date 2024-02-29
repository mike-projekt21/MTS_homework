import childClasses.Cat;
import childClasses.Dog;
import childClasses.Pet;

import java.time.LocalDate;

public class PetFactory extends AnimalFactory{
    @Override
    public Pet createAnimal (String [] animalData) {
        Pet animal = null;

        switch (animalData[0]) {
            case "Dog":
                animal = new Dog(animalData[1],
                        animalData[2],
                        Double.parseDouble(animalData[3]),
                        animalData[4],
                        LocalDate.of(Integer.parseInt(animalData[5].split("-")[2]),
                                Integer.parseInt(animalData[5].split("-")[1]),
                                Integer.parseInt(animalData[5].split("-")[0])
                        ));
                break;
            case "Cat":
                animal = new Cat(animalData[1],
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
