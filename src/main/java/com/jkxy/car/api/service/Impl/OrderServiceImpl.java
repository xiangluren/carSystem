package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.CarDao;
import com.jkxy.car.api.dao.OrderDao;
import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.Order;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.logging.Logger;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CarService carService;

    @Autowired
    private CarDao carDao;

    @Override
    @Transactional
    public void insertOrder(Order order) throws Exception {
        System.out.println(order.getIsInsurance());
        Car car = new Car();
        if(!StringUtils.isEmpty(order.getCarmessageId())){
            car = carService.findById(order.getCarmessageId());
        }else{
            throw new Exception("车系ID不能为空");
        }


        if(car.getInventory()>=order.getBuyCount()){
            orderDao.insertOrder(order);
            car.setInventory(car.getInventory()-order.getBuyCount());
            System.out.println(car.getInventory());
            carDao.updateById(car);
        }else {
            throw new Exception("库存不足");
        }



    }
}
