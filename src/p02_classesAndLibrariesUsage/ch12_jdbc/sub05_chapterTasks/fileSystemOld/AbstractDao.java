package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystemOld;

import java.util.List;

public abstract class AbstractDao <T extends Entity> {
    protected WrapperConnector wrapperConnector;

    public AbstractDao(WrapperConnector wrapperConnector) {
        this.wrapperConnector = wrapperConnector;
    }

    public abstract List<T> findAll();

    public abstract T findEntityById(int id);

    public abstract boolean createEntity(T entity);

    public abstract boolean updateEntity(T entity);

}
