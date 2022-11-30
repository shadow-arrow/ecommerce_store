package hopkq.store.services.impl;

import hopkq.store.entities.ShippingAddress;
import hopkq.store.repositories.ShippingAddressRepository;
import hopkq.store.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingAddressImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Override
    public ShippingAddress getShippingAddressByOrderId(int orderId) {
        return shippingAddressRepository.getShippingAddressByOrderId(orderId);
    }
}
