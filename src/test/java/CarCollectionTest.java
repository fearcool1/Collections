import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarCollectionTest {
    CarCollection<Car> carCollection;
    @Before
    public void setUp() throws Exception {
        carCollection = new CarArrayList<>();
        for(int i = 0; i < 100; i++){
            carCollection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void testForeach() {
        int index = 0;
        for(Car car : carCollection){
            index++;
        }
        assertEquals(100, index);
    }
}