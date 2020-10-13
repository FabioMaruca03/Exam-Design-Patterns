/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.reactive.systems.designpatternsandlambdas_1.task2;

import com.lit.reactive.systems.designpatternsandlambdas_1.pojos.Car;
import com.lit.reactive.systems.designpatternsandlambdas_1.task3.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author James
 */
public class Task2 {

    public static void main(String[] args){
        List<Car> cars = new ArrayList<>();

        cars.add(new Car( "BMW",  "1 Series", 39345));
        cars.add(new Car( "Nissan",  "micra", 16895 ));
        cars.add(new Car( "Volkswagon",  "Golf", 23950));
        cars.add(new Car( "Skoda",  "Superb", 32080));
        cars.add(new Car( "Kia",  "Sportage", 36450));

        System.out.println("Default list");
        cars.forEach(System.out::println);

        List<String> cars_model = cars.stream().map(Car::getModel).collect(Collectors.toList());

        System.out.println("\nModels list");
        cars_model.forEach(System.out::println);

        cars.forEach(it->it.setPrice((int)(it.getPrice()/1.21)));

        System.out.println("\nCars without VAT list");
        cars.forEach(System.out::println);

        System.out.println("\nCars that can be bought with 25000");
        cars.stream().filter(it->it.getPrice() <= 25000).forEach(System.out::println);

        System.out.println("\nCar can be bought with 25000?");
        cars.stream().map(it->it.getPrice() <= 25000).forEach(System.out::println);

    }
}
