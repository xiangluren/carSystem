package com.jkxy.car.api.controller;


import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.Order;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.service.OrderService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 新增订单
     *
     * @return
     */
    @PostMapping("/insertOrder")
    public JSONResult insertCar(@RequestBody(required = false) Order order) throws Exception {
        System.out.println(order.getIsInsurance());
        orderService.insertOrder(order);
        return JSONResult.ok();
    }
}
