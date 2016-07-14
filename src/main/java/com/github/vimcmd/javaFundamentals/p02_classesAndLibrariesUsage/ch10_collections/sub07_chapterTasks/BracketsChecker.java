package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub07_chapterTasks;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketsChecker {
    private BracketsChecker() {
    }

    private static final Map<Character, Character> brackets = new HashMap<Character, Character>() {
        {
            this.put('(', ')');
            this.put('[', ']');
            this.put('{', '}');
        }
    };

    public static boolean check(String in) {
        Stack<Character> stack = new Stack<>();
        for ( char ch : in.toCharArray() ) {
            if (brackets.containsKey(ch)) {
                stack.add(brackets.get(ch));
            }

            try {
                if (brackets.containsValue(ch) && ch != stack.pop()) {
                    return false;
                }
            } catch (EmptyStackException e) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}