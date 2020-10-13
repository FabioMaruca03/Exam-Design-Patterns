/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.reactive.systems.designpatternsandlambdas_1.task1;

import com.lit.reactive.systems.designpatternsandlambdas_1.pojos.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * @author James
 */
public class Task1 {

    public static void main(String[] args){
        List<Car>cars = new ArrayList<>();

        cars.add(new Car( "BMW",  "1 Series", 39345));
        cars.add(new Car( "Nissan",  "micra", 16895 ));
        cars.add(new Car( "Volkswagon",  "Golf", 23950));
        cars.add(new Car( "Skoda",  "Superb", 32080));
        cars.add(new Car( "Kia",  "Sportage", 36450));

        System.out.println("Default list");
        cars.forEach(System.out::println);

        cars.sort(Comparator.comparingInt(Car::getPrice));

        System.out.println("\nSorted list - 1");
        cars.forEach(System.out::println);

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getMake().equals("Skoda")){
                Car toMove = cars.get(i);
                cars.set(i, cars.get(0));
                cars.set(0, toMove);
            }
        }

        System.out.println("\nSorted list - 2");
        cars.forEach(System.out::println);

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getMake().equals("BMW")){
                Car toMove = cars.get(i);
                cars.set(i, cars.get(cars.size()-1));
                cars.set(cars.size()-1, toMove);
            }
        }

        System.out.println("\nSorted list - 3");
        cars.forEach(System.out::println);

        cars.forEach(it->{
            char[] chars = it.getModel().toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            it.setModel(String.valueOf(chars));
        });
        cars.sort((a, b) -> Arrays.compare(a.getModel().toCharArray(), b.getModel().toCharArray()));

        System.out.println("\nSorted list - 4");
        cars.forEach(System.out::println);
    }
}
