package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub05_prototype.generic;

import java.util.List;

// # 24 # interface for classes for work with prototypes

public interface Client<T> {

    T cloneElementById(Integer id) throws IllegalAccessException;

    List<T> cloneElements(Object... param);

    // other methods

}
