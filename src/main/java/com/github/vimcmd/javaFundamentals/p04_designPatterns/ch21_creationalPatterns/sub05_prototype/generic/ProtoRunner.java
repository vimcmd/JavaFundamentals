package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub05_prototype.generic;

import java.util.ArrayList;
import java.util.List;

public class ProtoRunner {

    public static void main(String[] args) {
        ArrayList<Issue> issueList = new ArrayList<Issue>(){
            {
                this.add(new Book(615, "Steve McConnell", "Code Complete", 2012));
                this.add(new Book(721, "Joshua Bloch", "Effective Java", 200));
                this.add(new Magazine(1009, 9, "PC Magazine", 2012));
                this.add(new Book(453, "Bruce Eckel", "Thinking in Java", 2006));
            }
        };
        IssueCachePrototype cache = new IssueCachePrototype(issueList);
        Issue copy = null;
        try {
            copy = cache.cloneElementById(453);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(issueList);
        System.out.println(copy);
    }

}
