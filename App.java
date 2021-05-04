import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    private static final IStringRowsListSorter SORTER = Task1Impl.INSTANCE;

    public static void main(String[] args) {
        List<String[]> strings = new ArrayList<>();
        strings.add(new String[]{"s", "s", "s"});
        strings.add(new String[]{"11", "s", "s"});
        strings.add(new String[]{"1", "s", "s"});
        strings.add(new String[]{"ss", "ss", "ss"});
        strings.add(new String[]{"11a", "s", "s"});
        strings.add(new String[]{"11b", "s", "s"});
        strings.add(new String[]{"ss12", "ss", "ss"});
        strings.add(new String[]{"1000", "ss", "ss"});
        strings.add(new String[]{"2000", "ss", "ss"});
        strings.add(new String[]{"2000aaaa", "ss", "ss"});
        strings.add(new String[]{"2000baaa", "ss", "ss"});
        strings.add(new String[]{"ss100bb", "SSS", "ss"});
        strings.add(new String[]{"ss100aa", "SSS", "ss"});
        strings.add(new String[]{"ss100aa10", "SSS", "ss"});
        strings.add(new String[]{"ss100aa20", "SSS", "ss"});
        strings.add(new String[]{"ss100", "AAA", "ss"});
        strings.add(new String[]{null, "ss", "ss"});
        strings.add(new String[]{"ss11", "ss", "ss"});
        strings.add(new String[]{"ss200", "ss", "ss"});
        strings.add(new String[]{"  ", "ss", "ss"});


        strings.forEach(arr-> System.out.println(Arrays.toString(arr)));
        System.out.println();
        SORTER.sort(strings,0);
        strings.forEach(arr-> System.out.println(Arrays.toString(arr)));
        System.out.println();
        SORTER.sort(strings,0);
        strings.forEach(arr-> System.out.println(Arrays.toString(arr)));
    }
}
