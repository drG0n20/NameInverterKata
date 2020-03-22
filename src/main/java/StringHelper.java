import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class StringHelper {
    public static String createInvertedString(ArrayList<String> splitName) {

        splitName.removeIf(n -> List.of("Pan", "Pani").contains(n));

        return String.join(", ", revertList(splitName));
    }

    private static ArrayList<String> revertList(ArrayList<String> splitName) {
        return Lists.newArrayList(splitName.stream()
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator());
    }

    public static boolean isEmptyOrSpaces(String name) {
        return name.trim().isEmpty();
    }
}
