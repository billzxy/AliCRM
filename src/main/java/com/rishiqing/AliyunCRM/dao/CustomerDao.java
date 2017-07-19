package com.rishiqing.AliyunCRM.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 117_John on 7/19/2017.
 */
@Repository("customerDao")
public interface CustomerDao {

        long saveAnimal(Animal animal);
        long deleteAnimal(Animal animal);
        List<Animal> getAllAnimals();
        Animal getAnimalById(String id);

}
