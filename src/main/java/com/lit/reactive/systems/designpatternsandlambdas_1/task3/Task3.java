/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.reactive.systems.designpatternsandlambdas_1.task3;


import com.lit.reactive.systems.designpatternsandlambdas_1.pojos.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author James
 */
public class Task3 {

    public static ComparingTask<Car> checkCheaper(Car car1) {
        return (o1, o2) -> o1.getPrice()<car1.getPrice() && o2.getPrice()<car1.getPrice();
    }
    
    public static void main(String[] args){
        List<Car> cars = new ArrayList<>();

        cars.add(new Car( "BMW",  "1 Series", 39345));
        cars.add(new Car( "Nissan",  "micra", 16895 ));
        cars.add(new Car( "Volkswagon",  "Golf", 23950));
        cars.add(new Car( "Skoda",  "Superb", 32080));
        cars.add(new Car( "Kia",  "Sportage", 36450));

        ComparingTask<Car> task = checkCheaper(cars.get(3));

        System.out.println("\nCheck - 1");
        List<Car> excluded = cars.stream().filter(it->it != cars.get(3)).collect(Collectors.toList());
        for (int i = 0; i < excluded.size()-1; i++) {
            System.out.println(task.compare(cars.get(i), cars.get(i+1)));
        }

        System.out.println("\nCheck - 2");
        System.out.println(task.compare(cars.get(1), cars.get(0)));

    }
}
