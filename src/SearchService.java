import childClasses.AbstractAnimal;

import java.util.List;

public interface SearchService {
    public List<AbstractAnimal> findLeapYearNames();
    public List<AbstractAnimal> findOlderAnimal(int n);
    public void findDuplicate();
}
