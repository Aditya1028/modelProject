/**
* The FoodManagementController interface having definition of rest controller get create and delete request
* to food operation.
*
* @author  xyz
* @version 1.0
* @since   2021-06-21 
*/
package com.atradius.cibt.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.atradius.cibt.model.Food;
import com.atradius.cibt.model.Response;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public interface FoodManagmentController {
	
	@GetMapping(value = "/public/getFoods", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Return all Foods with details", notes="This is a public API", response=List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity getFoods(@ApiParam(value = "" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType
			,@ApiParam(value = "" , defaultValue="Bearer {token}") @RequestHeader(value="Authorization", required=false) String authorization);
	
	@PostMapping(value = "/admin/addFood", 
			produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Add a new Food with details", notes="This is a public API with admin right", response=Response.class)
	@ApiResponses(value = { 
			@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "A new food has been added successfully"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Invalid Consumer Key")
	})
	ResponseEntity addFood(@ApiParam(value = "" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType
			,@ApiParam(value = "" , defaultValue="Bearer {token}") @RequestHeader(value="Authorization", required=false) String authorization, @RequestBody Food food);
	
	@DeleteMapping(value = "/admin/removeFood/{id}")
	@ApiOperation(value="Remove an existing Food", notes="This is a public API with admin right", response=Response.class)
	@ApiResponses(value = { 
			@ApiResponse(code = HttpServletResponse.SC_NO_CONTENT, message = "The food has been removed successfully"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "The Food does not exist")
	})
	ResponseEntity removeFood(@ApiParam(value = "" ,required=true) @RequestHeader(value="Content-Type", required=true) String contentType
			,@ApiParam(value = "" , defaultValue="Bearer {token}") @RequestHeader(value="Authorization", required=false) String authorization, @PathVariable("id") Long foodId);

}
