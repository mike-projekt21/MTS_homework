import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public interface CreateAnimalService {
    public default List tenAnimalCreation() {
        int countAnimal = 0;
        List zoo = new ArrayList<>();
        while (zoo.size() <= 10){
            System.out.println("Введите данные животных в следующем формате: название класса, порода, имя, стоимость, характер, дата рождения в формате день-месяц-год");
            String [] animalData = System.console().readLine().split(", ");
            switch (animalData[0]){
                case "Wolf":
                    zoo.add(new Wolf(animalData[1],
                                     animalData[2],
                                     Double.parseDouble(animalData[3]),
                                     animalData[4],
                                     LocalDate.of(Integer.parseInt(animalData[5].split("-")[2]),
                                             Integer.parseInt(animalData[5].split("-")[1]),
                                             Integer.parseInt(animalData[5].split("-")[0])
                                     ))
                    );
                    break;
                case "Shark":
                    zoo.add(new Wolf(animalData[1],
                            animalData[2],
                            Double.parseDouble(animalData[3]),
                            animalData[4],
                            LocalDate.of(Integer.parseInt(animalData[5].split("-")[2]),
                                    Integer.parseInt(animalData[5].split("-")[1]),
                                    Integer.parseInt(animalData[5].split("-")[0])
                            ))
                    );
                    break;
                case "Cat":
                    zoo.add(new Wolf(animalData[1],
                            animalData[2],
                            Double.parseDouble(animalData[3]),
                            animalData[4],
                            LocalDate.of(Integer.parseInt(animalData[5].split("-")[2]),
                                    Integer.parseInt(animalData[5].split("-")[1]),
                                    Integer.parseInt(animalData[5].split("-")[0])
                            ))
                    );
                    break;
                case "Dog":
                    zoo.add(new Wolf(animalData[1],
                            animalData[2],
                            Double.parseDouble(animalData[3]),
                            animalData[4],
                            LocalDate.of(Integer.parseInt(animalData[5].split("-")[2]),
                                    Integer.parseInt(animalData[5].split("-")[1]),
                                    Integer.parseInt(animalData[5].split("-")[0])
                            ))
                    );
                    break;
            }
        }
        for (Object i:zoo){
            System.out.println(i.toString());
        }
        return zoo;
    }
}
