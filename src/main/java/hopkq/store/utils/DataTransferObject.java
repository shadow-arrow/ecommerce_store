package hopkq.store.utils;

import hopkq.store.entities.Account;
import hopkq.store.entities.AccountDetail;
import hopkq.store.entities.Product;
import hopkq.store.models.RegisterAccount;
import hopkq.store.models.ShoppingCart;

import java.sql.Timestamp;

public class DataTransferObject {

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
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setName(registerAccount.getName());
        accountDetail.setPhoneNumber(registerAccount.getPhoneNumber());
        accountDetail.setGender(registerAccount.getGender() == 1 ? true : false);
        return accountDetail;
    }

    public Account convertRegisterAccountToAccount(RegisterAccount registerAccount) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Account account = new Account();
        account.setEmail(registerAccount.getEmail());
        account.setPassword(registerAccount.getPassword());
        account.setStatus(Common.Status.ACCOUNT_ACTIVE);
        account.setRoleId(Common.Role.CUSTOMER);
        account.setCreateDate(timestamp);
        return account;
    }


}
