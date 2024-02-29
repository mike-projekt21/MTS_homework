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
                animal = new Dog(animalData[2],
                        animalData[3],
                        Double.parseDouble(animalData[4]),
                        animalData[5],
                        LocalDate.of(Integer.parseInt(animalData[6].split("-")[0]),
                                Integer.parseInt(animalData[6].split("-")[1]),
                                Integer.parseInt(animalData[6].split("-")[2])
                        ));
                break;
            case "Cat":
                animal = new Cat(animalData[2],
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
