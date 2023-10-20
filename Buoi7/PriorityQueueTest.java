import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        // Test with list of integers
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        integerQueue.add(10);
        integerQueue.add(5);
        integerQueue.add(2);
        integerQueue.add(7);
        integerQueue.add(3);

        System.out.println("The elements in the priority queue are:");
        for (Integer element : integerQueue) {
            System.out.println(element);
        }

        // Test with list of objects with different keys and values
        PriorityQueue<Goods> goodsQueue = new PriorityQueue<>();
        goodsQueue.add(new Goods("Apple", 100));
        goodsQueue.add(new Goods("Banana", 50));
        goodsQueue.add(new Goods("Orange", 20));
        goodsQueue.add(new Goods("Peach", 70));
        goodsQueue.add(new Goods("Watermelon", 30));

        System.out.println("The elements in the priority queue are:");
        for (Goods goods : goodsQueue) {
            System.out.println(goods);
        }
    }
}

class Goods {

    String name;
    int price;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
