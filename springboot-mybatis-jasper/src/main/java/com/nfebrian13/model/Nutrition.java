package com.nfebrian13.model;

public class Nutrition {

	private int total;
	private String nutritionName;
	private int goal;
	private String metric;

	public Nutrition() {
		super();
	}

	public Nutrition(int total, String nutritionName, int goal, String metric) {
		super();
		this.total = total;
		this.nutritionName = nutritionName;
		this.goal = goal;
		this.metric = metric;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getNutritionName() {
		return nutritionName;
	}

	public void setNutritionName(String nutritionName) {
		this.nutritionName = nutritionName;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	@Override
	public String toString() {
		return "Nutrition [total=" + total + ", nutritionName=" + nutritionName + ", goal=" + goal + ", metric="
				+ metric + "]";
	}

}
