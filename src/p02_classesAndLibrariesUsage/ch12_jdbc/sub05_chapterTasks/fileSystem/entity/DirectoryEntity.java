package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.entity;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class DirectoryEntity extends AbstractEntity {
    private Set<String> children;

    public DirectoryEntity(String name) {
        // if file.separator in text,
        //      split and assign last value to name (with checkName())
        //      fo each create directory:
        //          for first dir - just create, for others - addSubDirectory (and move cursor)
        // else just assign name (with checkName())
        // TODO: 11.05.2016 add absolute path support, use mkdirs()
        super(name);
        children = new HashSet<>();
    }

    public DirectoryEntity addSubDirectory(DirectoryEntity subDirectory) {
        subDirectory.setParent(this);
        // uniqueness provided by name
        if (!children.contains(subDirectory.getName())) {
            this.children.add(subDirectory.getName());
            System.out.println("directory '" + subDirectory.getName() + "' CREATED in '" + this.getName() + "'");
        } else {
            System.err.println("directory '" + subDirectory.getName() + "' already EXISTS in '" + this.getName() + "'");
        }
        return subDirectory;
    }

    public FileEntity addSubFile(FileEntity subFile) {
        subFile.setParent(this);
        if (!children.contains(subFile.getName())) {
            this.children.add(subFile.getName());
            System.out.println("file '" + subFile.getName() + "' CREATED in '" + this.getName() + "'");
        } else {
            System.err.println("file '" + subFile.getName() + "' already EXISTS in '" + this.getName() + "'");
        }
        return subFile;
    }

    public Set getChildren() {
        return children;
    }

    private boolean mkdirs() {
        // TODO: 11.05.2016 implement method
        return false;
    }
}
