package com.atradius.cibt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atradius.cibt.entity.FoodEntity;

@Repository
public interface FoodDao {
	List<FoodEntity> getFoods();
	Boolean addFood(FoodEntity food);
	Boolean removeFood(Long foodId);
}
