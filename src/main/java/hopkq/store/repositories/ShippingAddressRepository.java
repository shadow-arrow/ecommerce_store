package hopkq.store.repositories;

import hopkq.store.entities.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {

    ShippingAddress save(ShippingAddress shippingAddress);


    ShippingAddress getShippingAddressByOrderId(int orderId);

}