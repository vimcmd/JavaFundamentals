package p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.DAO;

import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.WrapperConnector;
import p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.fileSystem.entity.AbstractEntity;

import java.sql.Statement;
import java.util.List;

public abstract class AbstractDao<T extends AbstractEntity> {
    protected WrapperConnector connector;

    // CRUD

    public abstract void create(T entity);

    public abstract void update(T entity);

    public abstract List<T> find(T entity);

    public void close() {
        connector.closeConnection();
    }

    public void closeStatement(Statement statement) {
        connector.closeStatement(statement);
    }
}
