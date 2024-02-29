import childClasses.*;

import java.time.LocalDate;

public class PredatorFactory extends AnimalFactory{
    @Override
    public Predator createAnimal (String [] animalData) {
        Predator animal = null;

        switch (animalData[0]) {
            case "Wolf":
                animal = new Wolf(animalData[1],
                        animalData[2],
                        Double.parseDouble(animalData[3]),
                        animalData[4],
                        LocalDate.of(Integer.parseInt(animalData[5].split("-")[2]),
                                Integer.parseInt(animalData[5].split("-")[1]),
                                Integer.parseInt(animalData[5].split("-")[0])
                        ));
                break;
            case "Shark":
                animal = new Shark(animalData[1],
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
