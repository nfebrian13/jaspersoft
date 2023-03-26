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
		
		try {
			
			File file = ResourceUtils.getFile("classpath:nutritionreport.jrxml");
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
	
}
