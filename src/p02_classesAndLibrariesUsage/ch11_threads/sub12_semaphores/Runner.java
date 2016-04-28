package p02_classesAndLibrariesUsage.ch11_threads.sub12_semaphores;

import java.util.LinkedList;
import java.util.Random;

/* # 22 # start and use pool */

public class Runner {
    public static void main(String[] args) {
        LinkedList<AudioChannel> list = new LinkedList<AudioChannel>(){
            {
                this.add(new AudioChannel(new Random().nextInt(1000)));
                this.add(new AudioChannel(new Random().nextInt(1000)));
                this.add(new AudioChannel(new Random().nextInt(1000)));
                this.add(new AudioChannel(new Random().nextInt(1000)));
                this.add(new AudioChannel(new Random().nextInt(1000)));
            }
        };

        for ( AudioChannel channel : list ) {
            System.out.println("Channel #" + channel.getChannelId() + " initialized");
        }

        ChannelPool<AudioChannel> pool = new ChannelPool<>(list);

        for(int i = 0; i < 20; i++) {
            new Client(pool).start();
        }
    }
}
