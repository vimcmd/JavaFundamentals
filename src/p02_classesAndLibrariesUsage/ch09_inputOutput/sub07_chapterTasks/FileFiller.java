package p02_classesAndLibrariesUsage.ch09_inputOutput.sub07_chapterTasks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileFiller {
    private File file;
    private FileWriter fileWriter;

    public FileFiller(File file) throws IOException {
        if (file.canWrite()) {
            this.file = file;
        } else {
            throw new IOException("Can not write to file");
        }
    }

    /**
     * Clears all content from file
     */
    public void clearFile() {
        try {
            fileWriter = new FileWriter(file, false);
            //fileWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Refills file with "lorem ipsum"
     */
    public void fillLorem() {
        try {
            final String lorem = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n" +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n" +
                    "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n" +
                    "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n" +
                    "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n" +
                    "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
            fileWriter = new FileWriter(file, false);
            fileWriter.write(lorem);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Refills file with poem "Knows how to forget!" by Emily Dickinson, 1830 - 1886
     */
    public void fillPoem() {
        try {
            String poem = "Knows how to forget!\n" +
                    "Emily Dickinson, 1830 - 1886\n" +
                    "\n" +
                    "Knows how to forget!\n" +
                    "But could It teach it?\n" +
                    "Easiest of Arts, they say\n" +
                    "When one learn how\n" +
                    "\n" +
                    "Dull Hearts have died\n" +
                    "In the Acquisition\n" +
                    "Sacrificed for Science\n" +
                    "Is common, though, now —\n" +
                    "\n" +
                    "I went to School\n" +
                    "But was not wiser\n" +
                    "Globe did not teach it\n" +
                    "Nor Logarithm Show\n" +
                    "\n" +
                    "“How to forget”!\n" +
                    "Say — some — Philosopher!\n" +
                    "Ah, to be erudite\n" +
                    "Enough to know!\n" +
                    "\n" +
                    "Is it in a Book?\n" +
                    "So, I could buy it —\n" +
                    "Is it like a Planet?\n" +
                    "Telescopes would know —\n" +
                    "\n" +
                    "If it be invention\n" +
                    "It must have a Patent.\n" +
                    "Rabbi of the Wise Book\n" +
                    "Don’t you know?";

            fileWriter = new FileWriter(file, false);
            fileWriter.write(poem);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
