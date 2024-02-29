import java.util.ArrayList;
import java.util.List;

public class CreateAnimalService {
    private final AnimalFactory factory;
    private List zoo;

    public CreateAnimalService(AnimalFactory factory) {
        this.factory = factory;
        this.zoo = new ArrayList<>();
    }

    public void tenAnimalCreation() {
        int countAnimal = 0;
        while (this.zoo.size() <= 10){
            System.out.println("Введите данные животных в следующем формате: название класса, порода, имя, стоимость, характер, дата рождения в формате день-месяц-год");
            String [] animalData = System.console().readLine().split(", ");
            this.zoo.add(factory.createAnimal(animalData));
        }
    }
    public void printZoo(){
        for (Object i:this.zoo){
            System.out.println(i.toString());
        }
    }
}
