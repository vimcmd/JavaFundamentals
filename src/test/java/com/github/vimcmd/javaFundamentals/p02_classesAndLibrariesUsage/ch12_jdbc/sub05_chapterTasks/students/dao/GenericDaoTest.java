package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public abstract class GenericDaoTest<T> {

    /**
     * Class of testable object
     */
    protected Class daoClass;

    /**
     * Domain object instance, which does not match any entry in storage system
     */
    protected Identified notPersistedDto;

    public GenericDaoTest(Class clazz, Identified<Integer> notPersistedDto) {
        this.daoClass = clazz;
        this.notPersistedDto = notPersistedDto;
    }

    /**
     * Instance of testable object
     */
    public abstract GenericDao dao();

    /**
     * Context of interaction with storage system
     */
    public abstract T context();

    @Test
    public void testCreate() throws Exception {
        Identified dto = dao().create();

        assertNotNull(dto);
        assertNotNull(dto.getId());
    }

    @Test
    public void testPersist() throws Exception {
        assertNull("Id before persist not null", notPersistedDto.getId());

        notPersistedDto = dao().persist(notPersistedDto);

        assertNotNull("Id after persist is null", notPersistedDto.getId());
    }

    @Test
    public void testGetByPk() throws Exception {
        Serializable id = dao().create().getId();
        Identified dto = dao().getByPk((Integer) id); // TODO: 15.05.2016 avoid casting
        assertNotNull(dto);
    }

    @Test
    public void testDelete() throws Exception {
        Identified dto = dao().create();
        assertNotNull(dto);

        List list = dao().getAll();
        assertNotNull(list);

        int oldSize = list.size();
        assertTrue(oldSize > 0);

        dao().delete(dto);

        list = dao().getAll();
        assertNotNull(list);

        int newSize = list.size();
        assertEquals(1, oldSize - newSize);
    }

    @Test
    public void testGetAll() throws Exception {
        List list = dao().getAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }
}