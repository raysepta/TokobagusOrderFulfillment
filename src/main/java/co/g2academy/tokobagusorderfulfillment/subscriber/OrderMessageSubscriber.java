package co.g2academy.tokobagusorderfulfillment.subscriber;

import co.g2academy.tokobagusorderfulfillment.dto.StoreFrontOrderItem;
import co.g2academy.tokobagusorderfulfillment.model.Order;
import co.g2academy.tokobagusorderfulfillment.dto.StoreFrontOrder;
import co.g2academy.tokobagusorderfulfillment.model.OrderItem;
import co.g2academy.tokobagusorderfulfillment.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMessageSubscriber implements MessageListener {
    private ObjectMapper mapper = new JsonMapper();

    @Autowired
    private OrderRepository repository;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String messageBody = new String(message.getBody());
        try {
            StoreFrontOrder sfOrder = mapper.readValue(messageBody, StoreFrontOrder.class);
            Order order = convert(sfOrder);
            repository.save(order);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }
    private Order convert(StoreFrontOrder sfOrder) {
        Order order = new Order();
        order.setStatus("PROCESS");
        order.setStoreFrontOrderId(sfOrder.getId());
        order.setTrxDate(sfOrder.getTrxDate());
        order.setTotalPrice(sfOrder.getTotalPrice());
        order.setTotalQuantity(sfOrder.getTotalQuantity());
        order.setUserId(sfOrder.getUser().getId());
        List<OrderItem> items = new ArrayList<>();
        for (StoreFrontOrderItem sfOrderItem : sfOrder.getItems()) {
            OrderItem item = new OrderItem();
            item.setPrice(sfOrderItem.getPrice());
            item.setQuantity(sfOrderItem.getQuantity());
            item.setStoreFrontOrderItemId(sfOrderItem.getId());
            item.setProductId(sfOrderItem.getProduct().getId());
            item.setProductName(sfOrderItem.getProduct().getName());
            item.setOrder(order);
            items.add(item);
        }
        order.setItems(items);
        return order;
    }
}
