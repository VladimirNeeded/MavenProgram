package Homework12;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
    MyArrayList<String> myArrayList = new MyArrayList<>();

    @Before
    public void initArrayList(){
        myArrayList.add("A");
        myArrayList.add("God");
        myArrayList.add("Juice box");
    }

    @Test
    public void testSize(){
        Assert.assertEquals(myArrayList.size(), 3);
    }

    @Test
    public void testAdd(){
        myArrayList.add("Banana");
        Assert.assertEquals(myArrayList.get(3), "Banana");
    }

    @Test
    public void testAddByIndex(){
        myArrayList.add("Mango", 1);
        Assert.assertEquals(myArrayList.get(1), "Mango");
    }

    @Test
    public void testAddAll(){
        MyArrayList<String> myArrayList2 = new MyArrayList<>();
        myArrayList2.addAll(myArrayList);
        Assert.assertEquals(myArrayList2.get(0), "A");
        Assert.assertEquals(myArrayList2.get(2), "Juice box");
        Assert.assertEquals(myArrayList2.size(), 3);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(myArrayList.get(1), "God");
    }

    @Test
    public void testSet(){
        myArrayList.set("1", 1);
        Assert.assertEquals(myArrayList.get(1), "1");
    }

    @Test
    public void testRemove(){
        myArrayList.remove("A");
        Assert.assertEquals(myArrayList.size(), 2);
    }

    @Test
    public void testRemoveByIndex(){
        myArrayList.remove(2);
        Assert.assertEquals(myArrayList.size(), 2);
    }

    @Test
    public void testIsEmpty(){
        MyArrayList myArrayList2 = new MyArrayList();
        Assert.assertEquals(myArrayList2.isEmpty(), true);
        Assert.assertEquals(myArrayList.isEmpty(), false);
    }
}
