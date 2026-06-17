import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamCollection {
    public static void main(String[] args){
        List<String> words = new ArrayList<>();
        words.add("Apple");
        words.add("Banana");
        words.add("HelloWorld");
        Predicate<String> predicate = (String s) -> {return s.length()>4;};
        Stream<String> largeOnly = words.stream().filter(predicate);

    }
}
