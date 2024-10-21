import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ztp03 {
    public static void main(String[] args) {
        Builder builder = new Builder();

        Director director = new Director(builder);

        director.constructFromString("M 100 400 L 200 50 L 450 300 L 250 250 Z M 300 350 L 350 100 L 50 200");

        Drawing drawing = builder.build();

        System.out.println(drawing);
    }
}
