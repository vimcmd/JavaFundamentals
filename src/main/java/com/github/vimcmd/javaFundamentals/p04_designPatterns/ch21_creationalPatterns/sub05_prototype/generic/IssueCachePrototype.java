package com.github.vimcmd.javaFundamentals.p04_designPatterns.ch21_creationalPatterns.sub05_prototype.generic;

import java.util.List;
import java.util.ArrayList;

// # 25 # class, creates and uses copy of instance

public class IssueCachePrototype implements Client<Issue> {

    private List<Issue> cache;

    public IssueCachePrototype() {
        cache = new ArrayList<Issue>();
    }


    public IssueCachePrototype(List<Issue> issueList) {
        this.cache = issueList;
    }

    @Override
    public Issue cloneElementById(Integer id) throws IllegalAccessException {
        for(Issue issue : cache) {
            if (issue.getId().equals(id)) {
                return issue.clone();
            }
        }
        throw new IllegalAccessException("Illegal id: " + id);
    }

    @Override
    public List<Issue> cloneElements(Object... param) {
        ArrayList<Issue> list = new ArrayList<>();
        // implementing search, cloning and organization new collection
        return list;
    }
}
