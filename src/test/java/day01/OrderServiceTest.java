package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 06, 07));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 06, 07));
        o3.addProduct(p1);
        o3.addProduct(p2);
        o3.addProduct(p3);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o4.addProduct(p3);
        o4.addProduct(p1);
        o4.addProduct(p2);

        Order o5 = new Order("pending", LocalDate.of(2021, 06, 07));
//        o5.addProduct(p1);
//        o5.addProduct(p2);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void getOrdersByStatusTest() {
    }

    @Test
    void numbersOfOrderByStatusTest() {
        assertEquals(3, orderService.numbersOfOrderByStatus("pending"));
        assertEquals(2, orderService.numbersOfOrderByStatus("on delivery"));
    }

    @Test
    void getOrdersBetweenDatesTest() {
        assertEquals(3, orderService.getOrdersBetweenDates(LocalDate.of(2021, 6, 5), LocalDate.of(2021, 6, 7)).size());
        assertEquals(5, orderService.getOrdersBetweenDates(LocalDate.of(2021, 6, 1), LocalDate.of(2021, 6, 10)).size());
        assertEquals(2, orderService.getOrdersBetweenDates(LocalDate.of(2021, 6, 1), LocalDate.of(2021, 6, 1)).size());
    }

    @Test
    void orderFewerThanTest() {
        assertTrue(orderService.orderFewerThan(4));
        assertTrue(orderService.orderFewerThan(3));
        assertFalse(orderService.orderFewerThan(2));
    }

    @Test
    void orderMax() {
        assertEquals(4, orderService.orderMax().getProducts().size());
    }

    @Test
    void orderFindByCategoryTest() {
        assertEquals(3, orderService.orderFindByCategory("Book").size());
        assertEquals(4, orderService.orderFindByCategory("IT").size());
    }
}
