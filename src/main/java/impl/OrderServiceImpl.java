package impl;



import java.util.List;


import exception.ResourceNotFoundException;
import model.Order;
import org.springframework.stereotype.Service;
import repo.OrderRepo;


@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepo orderRepository;




    public OrderServiceImpl(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }




    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }




    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
    }




    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }




    @Override
    public Order updateOrder(Long id, Order orderDetails) {
        Order order = getOrderById(id);
        // Update order details
        return orderRepository.save(order);
    }




    @Override
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}












