import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    public Map<String, List<String>> directory = new HashMap<>();

    //Метод добавления:
    public void add(String surname, String phone) {
        if (!directory.containsKey(surname)) {
            directory.put(surname, new ArrayList<>());
        }
        directory.get(surname).add(phone);
    }

    //Метод поиска:
    public List<String> get(String surname) {
        return directory.get(surname);
    }
}