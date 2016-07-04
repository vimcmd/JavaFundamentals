package com.github.vimcmd.javaFundamentals.p01_basics.ch06_interfacesAndAnnotations.sub03_annotations.primitive;

// # 16 # class annotation primitive usage

@BaseAction(level = 2, sqlRequest = "SELECT * FROM phonebook")
public class Base {

    public void doAction() {
        Class<Base> f = Base.class;
        BaseAction a = f.getAnnotation(BaseAction.class);
        System.out.println(a.level());
        System.out.println(a.sqlRequest());
    }

}
