import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;

import static org.junit.Assert.*;

public class CarMapTest {
    private CarHashMap<CarOwner, Car> map;

    @Before
    public void setUp() throws Exception {
        map = new CarHashMap<>();
    }
    @Test
    public void whenPut100ElementsThanSizeMustBe100(){
        for(int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner,car);
        }
        assertEquals(100, map.size());
    }
    @Test
    public void whenAdd100ElementsWith10DifferentKeysSizeMustBe10(){
        for(int i = 0; i < 100; i++){
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "Name" + index, "LastName" + index);
            Car car = new Car("Brand" + index, index);
            map.put(carOwner,car);
        }
        assertEquals(10, map.size());
    }

    @Test
    public void whenRemoveMustReturnTrueOnce(){
        for(int i = 0; i < 100; i++){
            CarOwner carOwner = new CarOwner( i ,"Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner,car);
        }
        CarOwner elementForDeleting  = new CarOwner(5,"Name5","LastName5");
        assertTrue(map.remove(elementForDeleting));
        assertEquals(99,map.size());
        assertFalse(map.remove(elementForDeleting));
    }
    @Test
    public void countOfKeysMustEqualsNumberOfValues() {
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name" + i, "LastName" + i);
            Car car = new Car("Brand" + i, i);
            map.put(carOwner, car);
        }
        assertEquals(100, map.size());
        System.out.println(map.keySet());
        assertEquals(100, map.keySet().size());
        assertEquals(100, map.values().size());
    }
}