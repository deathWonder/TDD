import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> contactList  = new HashMap<>();
    private static PhoneBook instance = null;
    private PhoneBook(){}

    public static PhoneBook getInstance() {
        if (instance == null) instance = new PhoneBook();
        return instance;
    }
    public Map<String, String> getContactList(){
        return contactList;
    }
    public int add(String name, String number){
        contactList.put(name, number);
        return contactList.size();
    }
    public String findByNumber(String number){
        return null;
    }
}
