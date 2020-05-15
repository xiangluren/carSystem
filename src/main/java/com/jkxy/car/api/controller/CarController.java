package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.KeyWordPage;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("findAll")
    public JSONResult findAll() {
        List<Car> cars = carService.findAll();
        return JSONResult.ok(cars);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //带斜杠是绝对路径，不带是相对路径；目前来看没啥不同
    @GetMapping("/findById")
    public JSONResult findById(@RequestParam(value = "id") int id) {
        Car car = carService.findById(id);
        return JSONResult.ok(car);
    }


    /**
     * 通过车名查询
     *
     * @param carName
     * @return
     */
    @GetMapping("findByCarName/{carName}")
    public JSONResult findByCarName(@PathVariable String carName) {
        List<Car> cars = carService.findByCarName(carName);
        return JSONResult.ok(cars);
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @GetMapping("deleteById/{id}")
    public JSONResult deleteById(@PathVariable int id) {
        carService.deleteById(id);
        return JSONResult.ok();
    }

    /**
     * 通过id更新全部信息
     *
     * @return
     */
    @PostMapping("updateById")
    public JSONResult updateById(Car car) {
        carService.updateById(car);
        return JSONResult.ok();
    }

    /**
     * 通过id增加
     *
     * @param car
     * @return
     */
    @PostMapping("insertCar")
    public JSONResult insertCar(Car car) {
        carService.insertCar(car);
        return JSONResult.ok();
    }


    /**
     * 对车辆进行模糊查询
     */
    @GetMapping("/findByKeyWord")
    public JSONResult findByKeyWord(@RequestParam("keyWord") String keyWord){
        List<Car> carsList = new ArrayList<Car>();
        carsList = carService.findByKeyWord(keyWord);
        return JSONResult.ok(carsList);
    }

    /**
     * 对车辆进行模糊查询
     */
    @PostMapping("/findByKeyWordByPage")
    public JSONResult findByKeyWordByPage(@RequestBody(required = false) KeyWordPage keyWordPage){
        List<Car> carsList = new ArrayList<Car>();
        carsList = carService.findByKeyWordByPage(keyWordPage);
        return JSONResult.ok(carsList);
    }
}
