package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderDao {

    @Insert("insert into ordermessage(carmessageId,buyer,buyCount,isLoan,isInsurance) values(#{carmessageId},#{buyer},#{buyCount},#{isLoan},#{isInsurance})")
    void insertOrder(Order order);
}
