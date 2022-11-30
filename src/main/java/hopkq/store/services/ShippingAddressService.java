package hopkq.store.services;

import hopkq.store.entities.ShippingAddress;

public interface ShippingAddressService {

    ShippingAddress getShippingAddressByOrderId(int orderId);

}
