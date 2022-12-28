//package mk.finki.ukim.mk.lab.repository;
//
//import mk.finki.ukim.mk.lab.model.Order;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static mk.finki.ukim.mk.lab.bootstrap.DataHolder.orders;
//@Repository
//public class OrderRepository {
//
//    public List<Order> findAll(){
//        return orders;
//    }
//    public Optional<Order> findById(Long id){
//        return orders.stream().filter(r->r.getOrderId().equals(id)).findFirst();
//    }
//    public Optional<Order>save(String balloonColor, String balloonSize, String clientName, String clientAddress){
//        Order o = new Order(balloonColor,balloonSize,clientName,clientAddress);
//        orders.add(o);
//        return Optional.of(o);
//    }
//
//
//}
