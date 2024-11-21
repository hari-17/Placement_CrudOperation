package impl;



import exception.ResourceNotFoundException;
import model.OrderItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.OrderItemRepo;

import java.util.List;


@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {




    private final OrderItemRepo orderItemRepository;




    public OrderItemServiceImpl(OrderItemRepo orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }




    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }




    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order item not found for this id :: " + id));
    }




    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }




    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItemDetails) {
        OrderItem orderItem = getOrderItemById(id);
        // Update the relevant fields of orderItem with orderItemDetails
        return orderItemRepository.save(orderItem);
    }




    @Override
    public void deleteOrderItem(Long id) {
        OrderItem orderItem = getOrderItemById(id);
        orderItemRepository.delete(orderItem);
    }
}










