package com.atradius.cibt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.atradius.cibt.model.Food;
import com.atradius.cibt.model.Response;
import com.atradius.cibt.service.FoodManagementService;

@Component
public class FoodManagmentControllerImpl implements FoodManagmentController {

	@Autowired
	FoodManagementService foodManagementService;

	@Override	
	public ResponseEntity getFoods(String contentType, String authorization) {
		List<Food> foods = foodManagementService.getFoods();
		return new ResponseEntity(foods, HttpStatus.OK);
	}

	@Override
	public ResponseEntity addFood(String contentType, String authorization, Food food) {
		foodManagementService.addFood(food);
		return new ResponseEntity(food.getId(), HttpStatus.CREATED);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ResponseEntity removeFood(String contentType, String authorization, Long foodId) {
		Boolean result = foodManagementService.removeFood(foodId);
		if (result) {
			return new ResponseEntity(result, (result) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(new Response("Invalid Id"), HttpStatus.BAD_REQUEST);
		}
	}
}
