package com.github.vimcmd.javaFundamentals.p01_basics.ch06_interfacesAndAnnotations.sub03_annotations.primitive;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// # 15 # simple class annotation

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BaseAction {
    int level();
    String sqlRequest();
}
