package com.duanc.utils;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component("exportExcelUtil")
public class ExportExcelUtil {
	
	@Autowired
	private MatchingExcel matchingExcel;
	private Workbook wb = null;
	private CellStyle titleStyle;
	private Font titleFont;
	private static final Logger LOGGER = LoggerFactory.getLogger(ExportExcelUtil.class);
	private String pattern  = "yyyy-MM-dd HH:mm:ss";
	
	public void exportExcel(List<?> values, List<?> headerNo, String fileName, HttpServletResponse response) {
		exportExcel(values, headerNo, fileName, response, null);
	}
	
	public void exportExcel(List<?> values, List<?> headerNo, String fileName, HttpServletResponse response, String excelVersion) {
		LOGGER.info("*************************Excel导出开始****************************");
		if(CollectionUtils.isEmpty(values) || CollectionUtils.isEmpty(headerNo) || null == response || 0 == values.size() ) {//�ж��Ƿ�����ݡ�IO��
			LOGGER.info("***********************没有数据传入或系统异常*****************************");
		} else {
		  try (BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());) {//JDK1.7新特性能自动关闭流
			if(null == excelVersion || "2003".equals(excelVersion)) {//判断是2003版本的Excel还是2007版本的Excel
				wb = new HSSFWorkbook();
			} else {
				fileName = fileName + "x";
				wb = new XSSFWorkbook();
			}
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename="+new String(fileName.getBytes("GBK"),
					"ISO8859-1"));
			Object object = values.get(0);
			Class<? extends Object> clazz = object.getClass();//获取反射		
			init();
			Sheet sheet = wb.createSheet();
			/*
		    sheet.setDefaultColumnWidth((short) 15);*/
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(1, true);
			Row headerRow = sheet.createRow(0),valRow;
			/*Row row = sheet.createRow(0);*/
			Cell cell;
			List<String> header = matchingExcel.getHeader(headerNo);
			for(int i = 0; i < header.size(); i++) {
				cell = headerRow.createCell(i);
				cell.setCellStyle(titleStyle);
				cell.setCellValue(header.get(i));
			}
			List<String> modelMember = matchingExcel.getModelMember(headerNo);
			for(int j = 0;j < values.size(); j ++) {
				valRow = sheet.createRow(j + 1);
				/*Field [] fileds = clazz.getDeclaredFields();*/
				for(int k = 0; k < header.size(); k++) {
					String key = modelMember.get(k);
					/*Field field = clazz.getDeclaredField(key);*/					
					cell = valRow.createCell(k);
					cell.setCellStyle(titleStyle);
					String getMethodName = "get"+key.substring(0, 1).toUpperCase()
			                   + key.substring(1);
					/*cell.setCellValue(field.toString());*/
					Method getMethod = clazz.getMethod(getMethodName, new Class[] {});				
					Object value = getMethod.invoke(values.get(j), new Object[] {});//获取值ֵ
					String valueStr = null;
					if(value == null) {
						
					} else if(value instanceof Date) {
						valueStr = DateFormatUtils.format((Date)value, pattern);
					} else {
						valueStr = value.toString();
					}
					cell.setCellValue(valueStr);
				}
			}
			LOGGER.info("************************Excel导出结束*********************");
			wb.write(bos);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		}
	}
	
	private void init() {
		titleStyle = wb.createCellStyle();
		titleFont = wb.createFont();
		initTitleFont();
		titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		titleStyle.setFont(titleFont);
		titleStyle.setFillBackgroundColor(IndexedColors.SKY_BLUE.index);
	}
	
	private void initTitleFont() {
		titleFont.setFontName("宋体");
		titleFont.setFontHeightInPoints((short)10);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		titleFont.setCharSet(Font.DEFAULT_CHARSET);
		titleFont.setColor(IndexedColors.BLUE_GREY.index);
	}
}
