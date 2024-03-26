package App;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Goat implements Winnable{
    private String name;
    @ToString.Exclude
    private int age;

}
