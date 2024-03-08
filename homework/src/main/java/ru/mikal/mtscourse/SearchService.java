package ru.mikal.mtscourse;

import ru.mikal.mtscourse.childClasses.AbstractAnimal;

import java.util.List;

public interface SearchService {
    public List<String> findLeapYearNames();
    public List<AbstractAnimal> findOlderAnimal(int n);
    public void findDuplicate();
}
