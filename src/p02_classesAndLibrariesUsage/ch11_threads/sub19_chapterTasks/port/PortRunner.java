package p02_classesAndLibrariesUsage.ch11_threads.sub19_chapterTasks.port;

import java.util.Random;

public class PortRunner {
    public static void main(String[] args) {

        Storage storage = new Storage(50);
        Port port = new Port(storage, 2);


        printStorageContents("port storage ", storage);

        for(int i = 0; i < 4; i++) {
            new Thread(new Ship(port, i, new Random().nextInt(20))).start();
        }

        //printStorageContents("port storage ", storage);
    }

    private static void printStorageContents(String label, Iterable<Container> storage) {
        System.out.println("Containers in " + label + ":");
        for ( Container container : storage ) {
            System.out.print("#" + container.getContainerId() + " ");
        }
        System.out.println();
    }
}
