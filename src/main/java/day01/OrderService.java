package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersByStatus(String status) {
        return orders.stream().filter(o -> o.getStatus().equals(status)).collect(Collectors.toList());
    }

    public long numbersOfOrderByStatus (String status) {
        return orders.stream().filter(o -> o.getStatus().equals(status)).count();
    }

    public List<Order> getOrdersBetweenDates (LocalDate date1, LocalDate date2) {
        return orders.stream().filter(o -> o.getOrderDate().isAfter(date1.minusDays(1)) && o.getOrderDate().isBefore(date2.plusDays(1))).collect(Collectors.toList());
    }

    public boolean orderFewerThan (int piece) {
        return orders.stream().anyMatch(o -> o.getProducts().size() < piece);
    }

    public Order orderMax () {
        return orders.stream().max(Comparator.comparing(o -> o.getProducts().size())).get();
    }

    public List<Order> orderFindByCategory (String category) {
        return orders.stream().filter(o -> o.getProducts().stream().anyMatch(x -> x.getCategory().equals(category))).collect(Collectors.toList());
    }


}
