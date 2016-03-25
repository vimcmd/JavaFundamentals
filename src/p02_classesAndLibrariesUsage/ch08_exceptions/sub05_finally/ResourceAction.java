package p02_classesAndLibrariesUsage.ch08_exceptions.sub05_finally;

import p02_classesAndLibrariesUsage.ch08_exceptions.sub04_throwOperator.SameResource;

/* # 4 # finally blocks execution */

public class ResourceAction {
    public static void main(String[] args) {
        ResourceAction ra = new ResourceAction();
        ra.doAction();
    }
    public void doAction() {
        SameResource sr = null;

        try {
            // realization - catch resources
            sr = new SameResource(); // possibly exception generation
            // realization - resource usage
            sr.execute();
            // sr.close(); // resource release (incorrect)
        } finally {
            System.out.println("Finally");
            // resource release (correct)
            if (sr != null) {
                sr.close();
            }
        }

        System.out.println("After finally");
    }
}
