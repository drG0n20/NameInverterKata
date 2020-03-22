import java.util.ArrayList;
import java.util.List;

class StringHelper {
    public static String createInvertedString(ArrayList<String> splitName) {
        splitName.removeIf(n -> List.of("Pan", "Pani").contains(n));
        return String.format("%s, %s", splitName.get(1), splitName.get(0));
    }

    public static boolean isEmptyOrSpaces(String name) {
        return name.trim().isEmpty();
    }
}
