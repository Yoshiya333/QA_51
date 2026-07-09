public interface Colored {

    String getColorFill();
    String getColorBord();

    default void printColorInfo() {
        System.out.println("Цвет заливки: " + getColorFill());
        System.out.println("Цвет границы: " + getColorBord());
    }
}
