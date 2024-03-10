package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.AbstractAnimal;
import ru.mikal.mtscourse.childClasses.Predator;
import ru.mikal.mtscourse.childClasses.Shark;
import ru.mikal.mtscourse.childClasses.Wolf;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Класс для работы с набором животных.(Отсутствовал в спецификации. Я его написал самостоятельно, собрав в кучу задания из ДЗ)
 * Имеет одно поле - список животных, экземпляров классов наследников {@link AbstractAnimal}
 * Переопределён конструктор {@link Zoo#Zoo()}
 * Имплементирует интерфейс {@link SearchService}
 */
public class Zoo implements SearchService{
    private List<AbstractAnimal> zoo; // список животных

    /**
     * Конструктор - создание нового объекта
     * Присваивает полю {@link Zoo#zoo} пустой нумерованный список
     */
    public Zoo() {
        this.zoo = new ArrayList<>();
    }
    /**
     * Конструктор - создание нового объекта
     * Присваивает полю {@link Zoo#zoo} полученный на вход нумерованный список животных
     * @param zoo нумерованный список животных, экземпляров классов наследников {@link AbstractAnimal}
     */
    public Zoo(ArrayList<AbstractAnimal> zoo) {
        this.zoo = zoo;
    }

    /**
     * Функция получения значения поля {@link Zoo#zoo}
     * @return возвращает список животных
     */
    public List<AbstractAnimal> getZoo() {
        return this.zoo;
    }

    /**
     * Процедура вывода на консоль всех объектов в списке {@link Zoo#zoo}
     */
    public void printZoo(){
        for (AbstractAnimal animal:this.zoo){
            if (animal != null) {
                System.out.println(animal.toString());
            }
        }
    }
    /**
     * Процедура создания объектов и добавления в список {@link Zoo#zoo} из переданных данных
     * @param data массив строк, каждая из которых состоит из значений полей для создания экземпляров классов, наследников {@link AbstractAnimal}
     *        все значения в строке разделены пробелом
     *        порядок перечисления значений в каждой строке см {@link AnimalFactory#createAnimal(String[])}
     */
    public void fillZoo(List<String> data){
        for (String animal_data:data) {
            String [] animalData = animal_data.split(", ");
            switch (animalData[0]) {
                case "Predator" -> {
                    PredatorFactory predatorFactory = new PredatorFactory();
                    this.zoo.add(predatorFactory.createAnimal(animalData));
                }
                case "Pet" -> {
                    PetFactory petFactory = new PetFactory();
                    this.zoo.add(petFactory.createAnimal(animalData));
                }
                default -> {
                    AnimalFactory animalFactory = new AnimalFactory();
                    this.zoo.add(animalFactory.createAnimal(animalData));
                }
            }
        }
    }
    /**
     * Функция выбора в списке животных {@link Zoo#zoo} тех, у которых в дате рождения стоит високосный год
     * С помощью stream API формируется новый нумерованный список, в котором храняться имена оставшихся животных
     * @return возвращает список имён животных, родившихся в високосном году
     */
    @Override
    public ArrayList<String> findLeapYearNames() {
        return this.zoo.stream()
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .map(animal -> animal.getName())
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    /**
     * Функция выбора в списке животных {@link Zoo#zoo} объектов, старше переданного параметра
     * С помощью stream API формируется новый нумерованный список, в котором храняться животные старше параметра n
     * @param n целое число лет
     * @return возвращает список животных
     */
    @Override
    public ArrayList<AbstractAnimal> findOlderAnimal(int n) {
        return this.zoo.stream()
                .filter(animal -> (Period.between(animal.getBirthDate(), LocalDate.now()).getYears()) > n)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    /**
     * Функция выбора в списке животных {@link Zoo#zoo} дубликатов
     * С помощью stream API формируется новый нумерованный список, в котором храняться животные, которые существуют в списке {@link Zoo#zoo} в нескольких экземплярах
     * @return возвращает список животных
     */
    @Override
    public ArrayList<AbstractAnimal> findDuplicate() {
/*
        return this.zoo.stream()
                .filter(animal -> Collections.frequency(this.zoo, animal) >1)
                .collect(Collectors.toSet())
                .stream()
                .distinct()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
*/

        ArrayList<AbstractAnimal> result = new ArrayList<AbstractAnimal>();
        int count;
        for (AbstractAnimal animal:this.getZoo()) {
            count = 0;
            for (AbstractAnimal animal_iterator:this.getZoo()) {
                if (animal.equals(animal_iterator)){
                    count++;
                }
            }
            if (count > 1 && !result.contains(animal)){
                result.add(animal);
            }
        }
        return result;


    }
}

