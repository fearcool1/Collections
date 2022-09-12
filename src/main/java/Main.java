public class Main {
    public static void main(String[] args) {

        CarSet carSet = new CarHashSet();

        System.out.println(carSet.size());
        carSet.add(new Car("tesla", 200));
        carSet.add(new Car("tesla", 200));
        carSet.add(new Car("tesla", 200));

        System.out.println(carSet.size());
        Car car = new Car("bmv", 10);
        carSet.add(car);
        System.out.println(carSet.size());
        carSet.remove(car);
        System.out.println(carSet.size());
    }
}
