package Homework12;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {
    MyLinkedList<String> myLinkedList = new MyLinkedList<>();

    @Before
    public void initMyLinkedList(){
        myLinkedList.add("Bug");
        myLinkedList.add("Dog");
        myLinkedList.add("Animan");
        myLinkedList.add("Nunes");
    }

    @Test
    public void testSize(){
        Assert.assertEquals(myLinkedList.size(), 4);
    }

    @Test
    public void testAdd(){
        myLinkedList.add("Pic");
        Assert.assertEquals(myLinkedList.size(), 5);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(myLinkedList.get(1), "Dog");
    }

    @Test
    public void testSet(){
        myLinkedList.set("Kerch", 1);
        Assert.assertEquals(myLinkedList.get(1), "Kerch");
    }

    @Test
    public void testRemove(){
        myLinkedList.remove("Nunes");
        Assert.assertEquals(myLinkedList.size(), 3);
    }

    @Test
    public void testAddByIndex(){
        myLinkedList.add("Lucas", 0);
        Assert.assertEquals(myLinkedList.get(0), "Lucas");
    }

    @Test
    public void testAddAll(){
        MyLinkedList<String> myLinkedList2 = new MyLinkedList<>();
        myLinkedList2.add("Car");
        myLinkedList2.add("Car");
        myLinkedList.addAll(myLinkedList2);
        Assert.assertEquals(myLinkedList.size(), 6);
    }

    @Test
    public void testRemoveByIndex(){
        myLinkedList.remove(0);
        Assert.assertNotEquals(myLinkedList.get(0), "Bug");
        Assert.assertEquals(myLinkedList.size(), 3);
    }

    @Test
    public void testIsEmpty(){
        MyArrayList myLinkedList2 = new MyArrayList();
        Assert.assertEquals(myLinkedList2.isEmpty(), true);
        Assert.assertEquals(myLinkedList.isEmpty(), false);
    }
}