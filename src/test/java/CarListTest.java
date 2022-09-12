import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarListTest {
    private CarList<Car> carList;

    @Before
    public void setUp() {
        //init
        carList = new CarLinkedList<>();
        for(int i = 0; i < 100; i++){
            carList.add( new Car("brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThanSizeMustBe100(){
        assertEquals(100, carList.size());
    }
    @Test
    public void whenElementsRemovedByIndexThenSizeMustDecreased(){
        assertTrue(carList.removeAt(5));
        assertEquals(99,carList.size());
    }
    @Test
    public void whenElementsRemovedThenSizeMustDecreased(){
        Car car = new Car("Toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }
    @Test
    public void whenNonExistentElementRemovedThenReturnFalse(){
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car));
    }
    @Test
    public void whenListClearThenSizeMustBe0(){
        carList.clear();
        assertEquals(0, carList.size());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrowsException(){
        carList.get(100);
    }
    @Test
    public void methodGetReturnedRightValue(){
        Car car = carList.get(0);
        assertEquals("brand0", car.getBrand());
    }
    @Test
    public void insertIntoFirstPosition(){
        Car car = new Car("BMW", 1);
        carList.add(car, 0);
        assertEquals("BMW", carList.get(0).getBrand());
    }
    @Test
    public void insertIntoLastPosition(){
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        assertEquals("BMW", carList.get(100).getBrand());
    }
    @Test
    public void ifElementContainsThatReturnTrue(){
        Car car = new Car("BMW", 001);
        carList.add(car);
        assertTrue(carList.contains(car));
    }
}