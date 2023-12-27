package Week3.Lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataStructures {
    private List<User> users = new ArrayList<>();

    public DataStructures() {
        users = Arrays.asList(
                new User("Becir", Gender.MALE, 29),
                new User("Fatima", Gender.FEMALE, 105),
                new User("Adnan", Gender.MALE, 35)

        );
    };

    public List<User> getAll() {
        return this.users;
    }

    public Optional<User> getByName(String name){
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }

    public List<User> findAgeGreaterThan (int age) {
        return users.stream()
                .filter(user -> age <= user.getAge())
                .toList();
    }

    public List<Integer> multiplyAge() {
        return users
                .stream()
                .map(user -> user.getAge() * 2)
                .toList();
    }

    public void multiplyAgeAndPrint() {
        users.stream()
                .map(user -> user.getAge() * 2)
                .forEach(age -> System.out.println(age) );
    }

    public List<User> multiplyAgeReturnUserAndPrint(){
        return users.stream()
                .peek(user -> user.setAge(user.getAge() * 2) )
                .toList();
    }

    public void getByGender (Gender gender){
        users = users.stream()
                .filter(user -> user.getGender().equals(gender))
                .toList();
        for (User u : users) {
            System.out.println(u.getName());
        }
    }
}
