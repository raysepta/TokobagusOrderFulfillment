package co.g2academy.tokobagusorderfulfillment.repository;

import co.g2academy.tokobagusorderfulfillment.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
