package source.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private int id;
    private String name;
    private String midleName;
    private String surname;
    private int yearOfBirth;
    private int countryKey;

    public Actor(int id) {
        this.id = id;
    }
}
