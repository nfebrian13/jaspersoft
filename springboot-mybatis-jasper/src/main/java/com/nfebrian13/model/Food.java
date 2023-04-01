package com.nfebrian13.model;

public class Food {

	private String foodName;
	private String mealtime;
	private int fat;
	private int protein;
	private int carbohydrate;

	public Food() {
		super();
	}

	public Food(String foodName, String mealtime, int fat, int protein, int carbohydrate) {
		super();
		this.foodName = foodName;
		this.mealtime = mealtime;
		this.fat = fat;
		this.protein = protein;
		this.carbohydrate = carbohydrate;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getMealtime() {
		return mealtime;
	}

	public void setMealtime(String mealtime) {
		this.mealtime = mealtime;
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public int getProtein() {
		return protein;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

}
