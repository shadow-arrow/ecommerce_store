package hopkq.store.utils;

import hopkq.store.entities.*;
import hopkq.store.models.InformationOrder;
import hopkq.store.models.RegisterAccount;
import hopkq.store.models.ShoppingCart;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

public class DataTransferObject {

    @Autowired
    private BCrypt bCrypt;


    public ShoppingCart convertProductToShoppingCart(Product product, int quantity) {
        ShoppingCart shoppingCart = new ShoppingCart();
        if (product != null) {
            shoppingCart.setId(product.getId());
            shoppingCart.setName(product.getName());
            shoppingCart.setQuantity(quantity);
            shoppingCart.setUnitPrice(product.getPrice());
            shoppingCart.setImageLink(product.getImageLink());
        }
        return shoppingCart;
    }

    public AccountDetail convertRegisterAccountToAccountDetail(RegisterAccount registerAccount) {
        AccountDetail accountDetail = AccountDetail.builder()
                .name(registerAccount.getName())
                .phoneNumber(registerAccount.getPhoneNumber())
                .gender(registerAccount.getGender() == 1 ? true : false)
                .build();
        return accountDetail;
    }

    public Account convertRegisterAccountToAccount(RegisterAccount registerAccount) {
        Account account = Account.builder()
                .email(registerAccount.getEmail())
                .password(bCrypt.hashpw(registerAccount.getPassword(), bCrypt.gensalt(10)))
                .status(Common.Status.ACCOUNT_ACTIVE)
                .roleId(Common.Role.CUSTOMER)
                .createDate(Common.getCurrentTimestamp())
                .build();
        return account;
    }


    public Order createOrder(int accountId, String note, float totalPrice) {

        Order order = Order.builder()
                .createDate(Common.getCurrentTimestamp())
                .accountId(accountId)
                .note(note)
                .totalPrice(totalPrice)
                .status(Common.Status.PROCESSING_ORDER)
                .build();
        return order;
    }

    public OrderDetail createOrderDetail(int orderId, ShoppingCart shoppingCart) {
        OrderDetail orderDetail = OrderDetail.builder()
                .orderId(orderId)
                .productId(shoppingCart.getId())
                .productName(shoppingCart.getName())
                .productPrice(shoppingCart.getUnitPrice())
                .productQuantity(shoppingCart.getQuantity())
                .build();
        return orderDetail;
    }

    public ShippingAddress createShippingAddress(int orderId, InformationOrder info) {
        ShippingAddress shippingAddress = ShippingAddress.builder()
                .orderId(orderId)
                .name(info.getName())
                .phoneNumber(info.getPhoneNumber())
                .address(info.getAddress())
                .build();
        return shippingAddress;
    }


}
