package com.nfebrian13.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.nfebrian13.mapper.EmployeeMapper;
import com.nfebrian13.model.Employee;
import com.nfebrian13.model.Food;
import com.nfebrian13.model.Nutrition;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private EmployeeMapper employeeMapper;

	public String exportReport(String reportFormat) throws JRException {
		String path = "C:\\Course\\SPRINGBOOT-JASPER\\result-jasper\\";
		List<Employee> employees = employeeMapper.findAllEmployee();

		try {
			File file = ResourceUtils.getFile("classpath:employee.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

			Map<String, Object> parameters = new HashMap<>();
			parameters.put("CreatedBy", "nfebrian13");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

			if (reportFormat.equalsIgnoreCase("html")) {
				JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "employees.html");
			}

			if (reportFormat.equalsIgnoreCase("pdf")) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, path + "employees.pdf");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("masuk");
		}
		return path;
	}

	public String exportNutiritionReport(String reportFormat) throws JRException {

		String filePath = "C:\\Course\\SPRINGBOOT-JASPER\\result-jasper\\";
		JRBeanCollectionDataSource nutritionDataSource = new JRBeanCollectionDataSource(paramNutritionList());

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("firstName", "Nana");
		parameters.put("lastName", "Febriana");
		parameters.put("dob", "13/02/1993");
		parameters.put("age", 30);
		parameters.put("nutritionDataset", nutritionDataSource);
		parameters.put("foodReport", getFoodReport());
		parameters.put("foodParameters", getFoodPrameter());

		try {

			File file = ResourceUtils.getFile("classpath:jasper/nutritionreport.jrxml");
			JasperReport report = JasperCompileManager.compileReport(file.getAbsolutePath());
			JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
			JasperExportManager.exportReportToPdfFile(print, filePath + "nutritionreport.pdf");
			System.out.println("Report Generate Successfully");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return "Report Generate Successfully";
	}

	public List<Nutrition> paramNutritionList() {
		List<Nutrition> nutritionList = new ArrayList<>();

		Nutrition protein = new Nutrition(62, "Protein", 83, "g");
		Nutrition carbohidrates = new Nutrition(180, "Carbohidrates", 206, "g");
		Nutrition fiber = new Nutrition(20, "Fiber", 38, "g");
		Nutrition fat = new Nutrition(60, "Fat", 55, "g");
		Nutrition sugars = new Nutrition(60, "Sugars", 62, "g");

		nutritionList.add(protein);
		nutritionList.add(carbohidrates);
		nutritionList.add(fiber);
		nutritionList.add(fat);
		nutritionList.add(sugars);

		return nutritionList;
	}

	public List<Food> paramFoodList() {
		List<Food> foodList = new ArrayList<>();

		Food banana = new Food("Banana", "breakfast", 0, 28, 1);
		Food avocado = new Food("Avocado", "breakfast", 0, 28, 1);
		Food milk = new Food("Milk", "breakfast", 0, 28, 1);
		Food chicken = new Food("Chicken", "lunch", 0, 28, 1);
		Food rice = new Food("Rice", "lunch", 0, 28, 1);
		Food egg = new Food("Egg", "lunch", 0, 28, 1);
		Food potato = new Food("Potato", "lunch", 0, 28, 1);
		Food oats = new Food("Oats", "lunch", 0, 28, 1);

		foodList.add(banana);
		foodList.add(avocado);
		foodList.add(milk);
		foodList.add(chicken);
		foodList.add(rice);
		foodList.add(egg);
		foodList.add(potato);
		foodList.add(oats);

		return foodList;
	}

	public static JRBeanCollectionDataSource getFoodDatasource() {
		List<Food> foodList = new ArrayList<>();

		Food banana = new Food("Banana", "breakfast", 0, 28, 1);
		Food avocado = new Food("Avocado", "breakfast", 0, 28, 1);
		Food milk = new Food("Milk", "breakfast", 0, 28, 1);
		Food chicken = new Food("Chicken", "lunch", 0, 28, 1);
		Food rice = new Food("Rice", "lunch", 0, 28, 1);
		Food egg = new Food("Egg", "lunch", 0, 28, 1);
		Food potato = new Food("Potato", "lunch", 0, 28, 1);
		Food oats = new Food("Oats", "lunch", 0, 28, 1);

		foodList.add(banana);
		foodList.add(avocado);
		foodList.add(milk);
		foodList.add(chicken);
		foodList.add(rice);
		foodList.add(egg);
		foodList.add(potato);
		foodList.add(oats);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(foodList);

		return dataSource;
	}

	private static Map getFoodPrameter() {
		Map<String, Object> foodParameter = new HashMap<>();
		foodParameter.put("foodDataset", getFoodDatasource());
		return foodParameter;
	}

	public JasperReport getFoodReport() throws JRException {
		JasperReport report = null;
		try {

			File file = ResourceUtils.getFile("classpath:jasper/food_nutrition.jrxml");
			report = JasperCompileManager.compileReport(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return report;
	}

}
