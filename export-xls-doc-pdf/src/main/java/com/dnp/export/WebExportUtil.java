package com.dnp.export;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class WebExportUtil {

	public static final String WORD = "word";
	public static final String EXCEL = "excel";
	public static final String PDF = "pdf";
	public static final String HTML = "html";

	/**
	 * <p>
	 * 生成jsperPrint对象，就是在填充数据。生成报表的过程.jrxml ===编译===> .jasper ===填充===>.jrprint
	 * ===导出===>excel、pdf、html、excel。。。。
	 * 
	 * @param jasperPath
	 *            .jsper的路径
	 * @param jasperPara
	 *            jasper 中parameters（参数对象要的值，如：$P{title}）
	 * @param data
	 *            这个是数据集合，就是detail你面的数据，循环显示他们的
	 * @return jsperPrint对象
	 * @throws JRException
	 */
	public static JasperPrint jasperPrint(String jasperPath, Map<String, Object> jasperPara, List<Map<String, Object>> data) throws JRException {
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(jasperPath));
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource((List) data);
		return JasperFillManager.fillReport(jasperReport, jasperPara, dataSource);
	}

	/**
	 * <p>
	 * description
	 * 
	 * @param type
	 *            导出的文件类型
	 * @param jasperPrint
	 *            生成的JasperPrint对象
	 * @param fileName
	 *            文件名称
	 * @param response
	 * @throws JRException
	 * @throws IOException
	 */
	public static void export(String type, JasperPrint jasperPrint, String fileName, HttpServletResponse response) throws JRException, IOException {
		if (WORD.equals(type))
			exportWord(jasperPrint, fileName, response);
		else if (EXCEL.equals(type))
			exportExcel(jasperPrint, fileName, response);
		else if (PDF.equals(type))
			exportPdf(jasperPrint, fileName, response);
		else if (HTML.equals(type))
			exportHtml(jasperPrint, response);
		else
			throw new IllegalArgumentException("invalid parameter!");
	}

	public static void exportWord(JasperPrint jasperPrint, String fileName, HttpServletResponse response) throws JRException, IOException {
		try {
			response.setHeader("content-disposition", "attachment;filename=" + fileName);
			response.setContentType("application/msword;charset=utf-8");
			JRDocxExporter jrDocxExporter = new JRDocxExporter();
			jrDocxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			jrDocxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
			jrDocxExporter.exportReport();
			response.getOutputStream().flush();
		} finally {
			if (!response.isCommitted() && response.getOutputStream() != null)
				response.getOutputStream().flush();
		}
	}

	public static void exportExcel(JasperPrint jasperPrint, String fileName, HttpServletResponse response) throws JRException, IOException {
		try {
			response.setHeader("content-disposition", "attachment;filename=" + fileName);
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
			exporter.exportReport();
			response.getOutputStream().flush();
		} finally {
			if (!response.isCommitted() && response.getOutputStream() != null)
				response.getOutputStream().flush();
		}
	}

	public static void exportPdf(JasperPrint jasperPrint, String fileName, HttpServletResponse response) throws JRException, IOException {
		try {
			response.setHeader("content-disposition", "attachment;filename=" + fileName);
			response.setContentType("application/pdf;charset=utf-8");
			JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
			response.getOutputStream().flush();
		} finally {
			if (!response.isCommitted() && response.getOutputStream() != null)
				response.getOutputStream().flush();
		}
	}

	public static void exportHtml(JasperPrint jasperPrint, HttpServletResponse response) throws JRException, IOException {
		try {
			response.setContentType("text/html;charset=utf-8");
			HtmlExporter htmlExporter = new HtmlExporter();
			htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getOutputStream(), "UTF-8"));
			htmlExporter.exportReport();
			response.getOutputStream().flush();
		} finally {
			if (!response.isCommitted() && response.getOutputStream() != null)
				response.getOutputStream().flush();
		}
	}

	public static String exportHtmlCode(JasperPrint jasperPrint) throws JRException, IOException {
		return JasperExportManager.exportReportToXml(jasperPrint);
	}
}
