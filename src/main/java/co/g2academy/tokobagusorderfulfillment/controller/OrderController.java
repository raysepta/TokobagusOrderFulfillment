package co.g2academy.tokobagusorderfulfillment.controller;

import co.g2academy.tokobagusorderfulfillment.model.Order;
import co.g2academy.tokobagusorderfulfillment.model.OrderItem;
import co.g2academy.tokobagusorderfulfillment.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
//    private ChannelTopic topic = new ChannelTopic("orderFulfillmentMessageQueue");
    private ChannelTopic topic = new ChannelTopic("orderFulfillmentMessageQueue");
    private ObjectMapper mapper = new JsonMapper();

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        Order order = orderRepository.findById(id).get();
        if (order != null) {
            for (OrderItem item : order.getItems()) {
                item.setOrder(null);
            }
        }
        return order;
    }

    @PutMapping("/order/{id}")
    public String updateOrderToDelivered(@PathVariable Integer id) {
        Order order = orderRepository.findById(id).get();
        if (order != null) {
            order.setStatus("DELIVERED");
            orderRepository.save(order);
            //send message back to Tokobagus Storefront to update order in their
            //part so both order data is in sync
            return "success";
        }
        return "fail";
    }

}
