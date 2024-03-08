package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.AbstractAnimal;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Zoo implements SearchService{
    private List<AbstractAnimal> zoo;

    public Zoo() {
        this.zoo = new ArrayList<>();
    }

    public List<AbstractAnimal> getZoo() {
        return this.zoo;
    }


    public void printZoo(){
        for (AbstractAnimal animal:this.zoo){
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
    @Override
    public List<AbstractAnimal> findLeapYearNames() {
        return this.zoo.stream()
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    @Override
    public List<AbstractAnimal> findOlderAnimal(int n) {
        return this.zoo.stream()
                .filter(animal -> (Period.between(animal.getBirthDate(), LocalDate.now()).getYears()) < n)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    @Override
    public void findDuplicate() {
        this.zoo.stream().filter(animal -> Collections.frequency(this.zoo, animal) >1)
                .collect(Collectors.toSet()).forEach(System.out::println);
    }
}

