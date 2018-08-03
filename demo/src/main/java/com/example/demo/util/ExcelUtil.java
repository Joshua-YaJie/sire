package com.example.demo.util;



import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ExcelUtil {
	private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);
	public static void setResponse(HttpServletResponse response, String filename) {

		try {
			filename = new String(filename.getBytes("UTF-8"), "iso8859-1");
		} catch (UnsupportedEncodingException e) {
			log.error("encode error", e);
		}
		response.reset();
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);// 指定下载的文件名
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	}


	/**
	 * 写excel
	 * 
	 * @param response
	 */
	public static void writeExcel(HttpServletResponse response, List<String> titles,List<String> fields,List<Map<String,Object>> resultList,String sheetName) {
		try {
			ServletOutputStream os = response.getOutputStream();
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(sheetName);
			HSSFRow titleRow = sheet.createRow(0);
			fillExcelTitle(titleRow, titles);
			if (CollectionUtils.isNotEmpty(resultList)) {
				fillContent(wb, sheet, resultList, fields);
			}
			wb.write(os);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 填充表单
	 * 
	 * @param titleRow
	 * @param titles
	 */
	private static void fillExcelTitle(HSSFRow titleRow, List<String> titles) {
		for (int i = 0; i < titles.size(); i++) {
			HSSFCell cell = titleRow.createCell(i);
			cell.setCellValue(titles.get(i));
		}
	}

	/**
	 * 填充单元格
	 * 
	 * @param sheet
	 * @param allList
	 * @param fields
	 */
	private static void fillContent(HSSFWorkbook wb, HSSFSheet sheet, List<Map<String, Object>> allList,
			List<String> fields) {
		try {
			for (int rowIdx = 0; rowIdx < allList.size(); rowIdx++) {
				Map<String, Object> map = allList.get(rowIdx);
				HSSFRow row = sheet.createRow(rowIdx + 1);
				String value;
				for (int cellIdx = 0; cellIdx < fields.size(); cellIdx++) {
					HSSFCell cell = row.createCell(cellIdx);
					String title = fields.get(cellIdx);
					value = String.valueOf(map.get(title) == null ? "" : map.get(title));
					cell.setCellValue(value);
				}
			}
		} catch (Exception e) {
			log.error("create excel error", e);
		}
	}

	/**
	 * read Excel
	 * @param in
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public  static List<Map<String,Object>> readZombieExcel(InputStream in,String fileName) throws Exception{
		List<Map<String,Object>> mapList = null;
		Workbook work =getWorkbook(in,fileName);
		if(null == work){
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		mapList = new ArrayList<>();
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			if(sheet==null){continue;}
			for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
				row = sheet.getRow(j);
				if(row==null||row.getFirstCellNum()==j){continue;}
				Map<String,Object> map = new HashedMap();
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					Object value = "";
					cell = row.getCell(y);
					if(cell != null){
						value = getCellValue(cell);
						if(y == 0){
							map.put("os",value);
						}else if(y == 1){
							map.put("ip",value);
						}else if(y == 2){
							map.put("port",value);
						}else if(y == 3){
							map.put("address",value);
						}else if(y == 4){
							map.put("zombieType",value);
						}else if(y == 5){
							map.put("innerIp",value);
						}else if(y == 6){
							map.put("computer",value);
						}else if(y == 7){
							map.put("location",value);
						}else if(y == 8){
							map.put("expireDate",value);
						}else if(y == 9){
							map.put("userStr",value);
						}else if(y == 10){
							map.put("taobaoUrl",value);
						}else if(y == 11){
							map.put("shopName",value);
						}else if(y == 12){
							map.put("price",value);
						}else if(y == 13){
							map.put("descrption",value);
						}
					}
				}
				mapList.add(map);
			}
		}
		return mapList;
	}

	/**
	 * read Ip Excel
	 * @param in
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public  static List<Map<String,Object>> readIpExcel(InputStream in,String fileName) throws Exception{
		List<Map<String,Object>> mapList = null;
		Workbook work =getWorkbook(in,fileName);
		if(null == work){
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		mapList = new ArrayList<>();
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			if(sheet==null){continue;}
			for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
				row = sheet.getRow(j);
				if(row==null||row.getFirstCellNum()==j){continue;}
				Map<String,Object> map = new HashedMap();
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					Object value = "";
					cell = row.getCell(y);
					if(cell != null){
						value = getCellValue(cell);
						if(y == 0){
							map.put("businessName",value);
						}else if(y == 1){
							map.put("ip",value);
						}else if(y == 2){
							map.put("os",value);
						}else if(y == 3){
							map.put("description",value);
						}else if(y == 4){
							map.put("ipBusClassfy",value);
						}
					}
				}
				mapList.add(map);
			}
		}
		return mapList;
	}

	/**
	 * read Device Excel
	 * @param in
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public  static List<Map<String,Object>> readDeviceExcel(InputStream in,String fileName) throws Exception{
		List<Map<String,Object>> mapList = null;
		Workbook work =getWorkbook(in,fileName);
		if(null == work){
			throw new Exception("创建Excel工作薄为空！");
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		mapList = new ArrayList<>();
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			if(sheet==null){continue;}
			for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
				row = sheet.getRow(j);
				if(row==null||row.getFirstCellNum()==j){continue;}
				Map<String,Object> map = new HashedMap();
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					Object value = "";
					cell = row.getCell(y);
					if(cell != null){
						value = getCellValue(cell);
						if(y == 0){
							map.put("deviceInfo",value);
						}else if(y == 1){
							map.put("brand",value);
						}else if(y == 2){
							map.put("deviceType",value);
						}else if(y == 3){
							map.put("serialNum",value);
						}else if(y == 4){
							map.put("cabinetNum",value);
						}else if(y == 5){
							map.put("laboratoryNum",value);
						}else if(y == 6){
							map.put("manageIp",value);
						}else if(y == 7){
							map.put("deviceIp",value);
						}else if(y == 8){
							map.put("businessClassfy",value);
						}else if(y == 9){
							map.put("businessDetail",value);
						}else if(y == 10){
							map.put("maintain",value);
						}else if(y == 11){
							map.put("deviceLocation",value);
						}
					}
				}
				mapList.add(map);
			}
		}
		return mapList;
	}

	/**
	 * 描述：根据文件后缀，自适应上传文件的版本
	 * @param inStr,fileName
	 * @return
	 * @throws Exception
	 */
	public static Workbook getWorkbook(InputStream inStr, String fileName) throws Exception{
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if(".xls".equals(fileType)){
			wb = new HSSFWorkbook(inStr);
		}else if(".xlsx".equals(fileType)){
			wb = new XSSFWorkbook(inStr);
		}
		return wb;
	}


	public static Object getCellValue(Cell cell) {
		Object cellValue = "";
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getRichStringCellValue().getString().trim();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
					cellValue = cell.getDateCellValue();
				}else {
					cellValue = cell.getNumericCellValue();
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
				break;
			case Cell.CELL_TYPE_FORMULA:
				cellValue = cell.getCellFormula();
				break;
			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
			default:
				cellValue = "";
		}
		return cellValue;
	}

}
