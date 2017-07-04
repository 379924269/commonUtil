package ExportToLocalUitl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;

import org.junit.Test;

import com.dnp.export.ExportToLocalUitl;
import com.ibm.icu.text.SimpleDateFormat;

public class ExportToLocalUtilTest {

	@Test
	public void exprotExcelTest() {
		try {
			ExportToLocalUitl.export(ExportToLocalUitl.EXCEL,
					ExportToLocalUitl.jasperPrint("src/main/resource/statisticsAppInOrg.jasper", getJasperParam(), getDate()), "E:/003/测试.xlsx");
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void exprotDocTest() {
		try {
			ExportToLocalUitl.export(ExportToLocalUitl.WORD,
					ExportToLocalUitl.jasperPrint("src/main/resource/statisticsAppInOrg.jasper", getJasperParam(), getDate()), "E:/003/测试.docx");
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void exprotPdfTest() {
		try {
			ExportToLocalUitl.export(ExportToLocalUitl.PDF,
					ExportToLocalUitl.jasperPrint("src/main/resource/statisticsAppInOrg.jasper", getJasperParam(), getDate()), "E:/003/测试.pdf");
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void exprotHtmlTest() {
		try {
			ExportToLocalUitl.export(ExportToLocalUitl.HTML,
					ExportToLocalUitl.jasperPrint("src/main/resource/statisticsAppInOrg.jasper", getJasperParam(), getDate()), "E:/003/测试.html");
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Map<String, Object> getJasperParam() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("title", "The First Jasper test");
		parameters.put("startTime", new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
		parameters.put("endTime", new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
		return parameters;
	}

	public static List<Map<String, Object>> getDate() {
		List<Map<String, Object>> dateList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("orgName", "部门" + i);
			parameters.put("userName", "huazai" + i);
			parameters.put("leaveTimes",i);
			parameters.put("tingsLeaveTimes",i);
			parameters.put("meetingTimes",i);
			parameters.put("businessTimes",i);
			parameters.put("goOnBusinessTimes",i);
			parameters.put("sickLeaveTimes",i);
			dateList.add(parameters);
		}
		return dateList;
	}
}
