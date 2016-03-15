package Core.javaLang.p01_Classes.Math;

/**
 * Sources:
 * <ul>
 * <li>
 * <p>
 * http://way2java.com/java-lang/class-math/
 * </li>
 * </ul>
 */
public class ClassMath {

    public static void main(String[] args) {
        test();
    }

    /**
     * The {@link Math} class contains static methods implementing math functions, such as:
     * <ul>
     * <li>Trigonometry: {@code sin(), cos(), tan(),} etc.</li>
     * <li>Rounding: {@code round(), floor(), ceil(), rint()}</li>
     * <li>Logarithmic: {@code log(), log10()}</li>
     * <li>Exponentiation: {@code sqrt(), cbrt(), pow(), exp()}</li>
     * <li>Utility: {@code abs(), min(), max(), random(), hypot(), toDegrees(), toRadians()}</li>
     * <li>{@code Math} also includes constants for PI and E</li>
     * </ul>
     */
    public static void test() {
        System.out.println(Math.rint(4.6));
    }


}
