package p02_classesAndLibrariesUsing.ch07_strings.sub01_stringClass;


public class SortStringArray {
    private final String initialString;

    public SortStringArray(String string) {
        this.initialString = string;
    }

    public static void main(String[] args) {
        SortStringArray sortExample = new SortStringArray(" Alena Alice alina albina Anastasya ALLA ArinA ");
        System.out.println("Initial string: " + sortExample.getInitialString());
        System.out.println("Sorted string : " + sortExample.sortStringArray());
    }

    public String getInitialString() {
        return initialString;
    }

    public String sortStringArray() {
        String string = getInitialString().trim();
        String stringArray[] = string.split(" ");
        for(int i = 0; i < stringArray.length - 1; i++) {
            for(int j = i + 1; j < stringArray.length; j++) {
                if (stringArray[j].compareToIgnoreCase(stringArray[i]) < 0) {
                    String temp = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }

        return String.join(" ", stringArray);
    }
}
