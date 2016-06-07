package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch12_jdbc.sub05_chapterTasks.students.dao;

import java.io.Serializable;

/**
 * Identified objects interface
 * @param <PK>
 */
public interface Identified<PK extends Serializable> {

    /**
     * Returns object primary key
     * @return primary key
     */
    PK getId();

}
