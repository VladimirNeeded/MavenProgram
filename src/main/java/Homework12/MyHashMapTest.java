package Homework12;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyHashMapTest {
    MyHashMap<Integer, String> myHashMap = new MyHashMap<>();

    @Before
    public void initArrayList(){
        myHashMap.put(1, "A");
        myHashMap.put(2, "B");
        myHashMap.put(3, "C");
    }

    @Test
    public void testPut() {
        myHashMap.put(4, "Cat");
        Assert.assertEquals(myHashMap.get(4), "Cat");
    }

    @Test
    public void testGet() {
        Assert.assertEquals(myHashMap.get(2), "B");
    }

    @Test
    public void testRemove() {
        myHashMap.remove(0);
        Assert.assertNull(myHashMap.get(0));
    }

    @Test
    public void testClear() {
        myHashMap.clear();
        Assert.assertEquals(myHashMap.size(), 0);
    }
}