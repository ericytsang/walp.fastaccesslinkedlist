package com.github.ericytsang.lib.fastaccesslinkedlist;
// : c15:FastAccessLinkedListTest2.java
//Simple use of JUnit to test ArrayList
//{Depends: junit.jar}
//From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
//www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.*;
import junit.framework.*;

public class FastAccessLinkedListTest2 extends TestCase
{
    private List<String> list = new FastAccessLinkedList<String>();

    // You can use the constructor instead of setUp():
    public FastAccessLinkedListTest2(String name)
    {
        super(name);
        for(int i = 0; i < 3; i++)
            list.add(""+i);
    }

    // All tests have method names beginning with "test":
    public void testInsert()
    {
        System.out.println("Running testInsert()");
        assertEquals(list.size(),3);
        list.add(1,"Insert");
        assertEquals(list.size(),4);
        assertEquals(list.get(1),"Insert");
    }

    public void testReplace()
    {
        System.out.println("Running testReplace()");
        assertEquals(list.size(),3);
        list.set(1,"Replace");
        assertEquals(list.size(),3);
        assertEquals(list.get(1),"Replace");
    }

    // A "helper" method to reduce code duplication. As long
    // as the name doesn't start with "test," it will not
    // be automatically executed by JUnit.
    private void compare(List lst,String[] strs)
    {
        Object[] array = lst.toArray();
        assertTrue("Arrays not the same length",array.length == strs.length);
        for(int i = 0; i < array.length; i++)
            assertEquals(strs[i],(String) array[i]);
    }

    public void testOrder()
    {
        System.out.println("Running testOrder()");
        compare(list,new String[]{"0","1","2"});
    }

    public void testRemove()
    {
        System.out.println("Running testRemove()");
        assertEquals(list.size(),3);
        list.remove(1);
        assertEquals(list.size(),2);
        compare(list,new String[]{"0","2"});
    }

    public void testAddAll()
    {
        System.out.println("Running testAddAll()");
        list.addAll(Arrays.asList("An","African","Swallow"));
        assertEquals(list.size(),6);
        compare(list,
            new String[]{"0","1","2","An","African","Swallow"});
    }

    public static void main(String[] args)
    {
        // Invoke JUnit on the class:
        junit.textui.TestRunner.run(FastAccessLinkedListTest2.class);
    }
}