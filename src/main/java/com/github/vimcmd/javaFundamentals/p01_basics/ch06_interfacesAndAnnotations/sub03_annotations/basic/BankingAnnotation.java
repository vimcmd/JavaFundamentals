package com.github.vimcmd.javaFundamentals.p01_basics.ch06_interfacesAndAnnotations.sub03_annotations.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// # 17 # method annotation

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BankingAnnotation {

    SecurityLevelEnum securityLevel() default SecurityLevelEnum.NORMAL;

}
