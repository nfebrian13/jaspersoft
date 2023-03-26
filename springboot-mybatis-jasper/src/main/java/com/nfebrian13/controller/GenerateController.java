package com.nfebrian13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nfebrian13.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class GenerateController {

	@Autowired
	private ReportService reportService;

	@GetMapping(path = "/report/{format}")
	public String generateReport(@PathVariable String format) throws JRException {
		return reportService.exportNutiritionReport(format);
	}
}
