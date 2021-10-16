package mypkg1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private StringWrapper firstName;
    private StringWrapper lastName;

    public Person(StringWrapper firstName, StringWrapper lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName.toString() + " " + lastName.toString();
    }
}
