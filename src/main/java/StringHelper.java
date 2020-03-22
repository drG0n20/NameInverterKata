import java.util.ArrayList;

class StringHelper {
    public static String createInvertedString(ArrayList<String> splitName) {
        splitName.removeIf(n -> "Pan".equals(n));
        return String.format("%s, %s", splitName.get(1), splitName.get(0));
    }

    public static boolean isEmptyOrSpaces(String name) {
        return name.trim().isEmpty();
    }
}
