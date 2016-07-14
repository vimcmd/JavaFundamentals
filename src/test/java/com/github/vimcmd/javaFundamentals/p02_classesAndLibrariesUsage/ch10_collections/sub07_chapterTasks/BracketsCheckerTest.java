package com.github.vimcmd.javaFundamentals.p02_classesAndLibrariesUsage.ch10_collections.sub07_chapterTasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class BracketsCheckerTest {

    @Test
    public void testCheckSimple() throws Exception {
        boolean result = BracketsChecker.check("((5+3)*2+1)"); // true, simple
        assertEquals(true, result);
    }

    @Test
    public void testCheckDifferentBracketsTypesOverlapping() throws Exception {
        boolean result = BracketsChecker.check("(3+{1-1)}"); // false, different bracket types overlapping
        assertEquals(false, result);
    }

    @Test
    public void testDifferentBracketTypes() throws Exception {
        boolean result = BracketsChecker.check("{[(3+1)+2]+}"); // true, different bracket types
        assertEquals(true, result);
    }

    @Test
    public void testDifferentOperations() throws Exception {
        boolean result = BracketsChecker.check("[1+1]+(2*2)-{3/3}"); // true, different operations
        assertEquals(true, result);
    }

    @Test
    public void testRedundantBracket() throws Exception {
        boolean result = BracketsChecker.check("(({[(((1)-2)+3)-3]/3}-3)"); // false, one bracket is redundant
        assertEquals(false, result);
    }

    @Test
    public void testValid() {
        assertEquals(true, BracketsChecker.check("()"));
        assertEquals(true, BracketsChecker.check("[]"));
        assertEquals(true, BracketsChecker.check("{}"));
        assertEquals(true, BracketsChecker.check("(){}[]"));
        assertEquals(true, BracketsChecker.check("([{}])"));
        assertEquals(true, BracketsChecker.check("({})[({})]"));
        assertEquals(true, BracketsChecker.check("(({{[[]]}}))"));
        assertEquals(true, BracketsChecker.check("{}({})[]"));
    }

    @Test
    public void testInvalid() throws Exception {
        assertEquals(false, BracketsChecker.check("[(])"));
        assertEquals(false, BracketsChecker.check("(}"));
        assertEquals(false, BracketsChecker.check("(})"));
        assertEquals(false, BracketsChecker.check(")(}{]["));
        assertEquals(false, BracketsChecker.check("())({}}{()][]["));
        assertEquals(false, BracketsChecker.check("(((({{"));
        assertEquals(false, BracketsChecker.check("}}]]))}])"));
    }
}