package Core.javaLang.p01_Classes.String;

/**
 * Sources:
 * <ul>
 * <li>
 * Java. Programming Methods (Epam free book, 2013) / chapter 7
 * </li>
 * </ul>
 */
public class StringTasks {

    private String initialString;
    private String resultString;
    public static final String lineSeparator = System.lineSeparator();

    public StringTasks(String initialString) {
        this.initialString = initialString;
    }

    public StringTasks() {
        this("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
                     "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut " +
                     "aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                     "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                     "culpa qui officia deserunt mollit anim id est laborum.");
    }

    public static void main(String[] args) {
        StringTasks stringTask = new StringTasks();
        System.out.println(stringTask);
        System.out.println(lineSeparator);
        System.out.println(stringTask.stringReverse());
    }

    public String getInitialString() {
        return initialString;
    }

    public String getResultString() {
        return resultString;
    }

    @Override
    public String toString() {
        return "Initial string: " + this.getInitialString() +
                lineSeparator +
                "Result string:  " + this.getResultString();
    }

    public String stringReverse() {
        return new StringBuilder(this.getInitialString()).reverse()
                                                         .toString();
    }
}