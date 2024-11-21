package impl;





import model.OrderItem;

import java.util.List;


public interface OrderItemService {
    OrderItem saveOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(Long id);
    List<OrderItem> getAllOrderItems();
    OrderItem updateOrderItem(Long id, OrderItem orderItem);
    void deleteOrderItem(Long id);
}












