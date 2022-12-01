package hopkq.store.controllers;


import hopkq.store.entities.Account;
import hopkq.store.entities.AccountDetail;
import hopkq.store.entities.Order;
import hopkq.store.models.OrderDetailModel;
import hopkq.store.services.AccountDetailService;
import hopkq.store.services.OrderDetailService;
import hopkq.store.services.OrderService;
import hopkq.store.services.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("account")
@RequestMapping(value = "")
public class UserController {

    @Autowired
    private AccountDetailService accountDetailService;

    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private ShippingAddressService shippingAddressService;

    @RequestMapping(value = "/user-info", method = RequestMethod.GET)
    public String goToPage(@ModelAttribute("account") Account account, ModelMap modelMap) {
        AccountDetail accountDetail = accountDetailService.getAccountDetailByID(account.getId());
        modelMap.addAttribute("accountDetail", accountDetail);
        return "user-profile";
    }


    @RequestMapping(value = "/user-orders", method = RequestMethod.GET)
    public String getAllOrdersByUser(@ModelAttribute("account") Account account, ModelMap modelMap) {
        List<Order> orderList = orderService.getAllOrdersByUser(account.getId());


        modelMap.addAttribute("orderList", orderList);
        return "user-orders";
    }

    @RequestMapping(value = "/detail-order", method = RequestMethod.GET)
    @ResponseBody
    public OrderDetailModel getOrderDetailInfo(@RequestParam(value = "id") int orderId) {
        OrderDetailModel result = new OrderDetailModel();
        try {
            result.setListOrderDetail(orderDetailService.getOrderDetailByOrderId(orderId));
            result.setShippingAddress(shippingAddressService.getShippingAddressByOrderId(orderId));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }


}
