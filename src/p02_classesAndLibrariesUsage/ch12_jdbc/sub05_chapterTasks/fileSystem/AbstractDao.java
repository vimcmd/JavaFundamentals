package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDao <T extends Entity> {
    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> findAll();

    public abstract T findEntityById(int id);

    public abstract boolean createEntity(T entity);

    public abstract boolean updateEntity(T entity);

}
