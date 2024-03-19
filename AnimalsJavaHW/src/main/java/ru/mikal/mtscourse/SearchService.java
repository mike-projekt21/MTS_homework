package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.AbstractAnimal;

import java.util.List;

/**
 * Интерфейс для рабоы со списками животных - экземпляров классов, наследников {@link AbstractAnimal}
 */
public interface SearchService {
    /**
     * Функция выбора в списке животных тех, у которых в дате рождения стоит високосный год
     * С помощью stream API формируется новый нумерованный список, в котором храняться имена оставшихся животных
     * @return возвращает список имён животных, родившихся в високосном году
     */
    public List<String> findLeapYearNames();

    /**
     * Функция выбора в списке животных объектов, старше переданного параметра
     * С помощью stream API формируется новый нумерованный список, в котором храняться животные старше параметра n
     * @param n целое число лет
     * @return возвращает список животных
     */
    public List<AbstractAnimal> findOlderAnimal(int n);

    /**
     * Функция выбора в списке животных дубликатов
     * С помощью stream API формируется новый нумерованный список, в котором храняться животные, которые существуют в списке {@link Zoo#zoo} в нескольких экземплярах
     * @return возвращает список животных
     */
    public List<AbstractAnimal> findDuplicate();
}
