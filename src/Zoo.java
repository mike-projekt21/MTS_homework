import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List zoo;

    public Zoo() {
        this.zoo = new ArrayList<>();
    }
    public void printZoo(){
        for (Object animal:this.zoo){
            if (animal != null) {
                System.out.println(animal.toString());
            }
        }
    }
    public void fillZoo(List<String> data){
        for (String animal_data:data) {
            String [] animalData = animal_data.split(", ");
            switch (animalData[0]){
                case "Predator":
                    PredatorFactory predatorFactory = new PredatorFactory();
                    this.zoo.add(predatorFactory.createAnimal(animalData));
                case "Pet":
                    PetFactory petFactory = new PetFactory();
                    this.zoo.add(petFactory.createAnimal(animalData));
                default:
                    AnimalFactory animalFactory = new AnimalFactory();
                    this.zoo.add(animalFactory.createAnimal(animalData));
            }
        }
    }
}
