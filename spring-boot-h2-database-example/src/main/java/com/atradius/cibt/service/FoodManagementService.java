package com.atradius.cibt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atradius.cibt.model.Food;

@Service
public interface FoodManagementService {
	public List<Food> getFoods();
	public Boolean addFood(Food food);
	public Boolean removeFood(Long foodId);
}
