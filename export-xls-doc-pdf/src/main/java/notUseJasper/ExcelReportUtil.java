package notUseJasper;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReportUtil {

    /**
     * Description: 通过数据生成excel到制定位置. 如果样式不满意可以自己设置一下CellStyle
     *
     * @param exportMsgList     : 需要生成excel的信息
     * @param excelCloumnNames  : 获取参数的列名称，如["userId","userName"]， 我通过它去获取对应的列的值,注意字段顺序
     * @param excelHheaderNames : excel header名称, 如["用户id","用户名称"]， 我们设置表头,注意字段顺序
     * @param excelTitle        : excel的标题,如：“用户信息”或“设备信息”等。。。
     * @param savePath          : 生成excel的保存路径，如："G:\\用户信息.xls"
     */
    public static void generateExportUsersExcel(List<Map<String, Object>> exportMsgList,
                                                List<String> excelHheaderNames, List<String> excelCloumnNames,
                                                String excelTitle, String savePath) throws IOException {
        int cellCount = excelHheaderNames.size();
        boolean hasBorder = false;

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet1");

        CellStyle titleCellStyle = setFontAlignAndBorder(workbook, HSSFCellStyle.ALIGN_CENTER, (short) 17, hasBorder);
        createTitle(titleCellStyle, sheet, excelTitle, cellCount);

        CellStyle headerCellStyle = setFontAlignAndBorder(workbook, HSSFCellStyle.ALIGN_CENTER, (short) 11, hasBorder);
        createHeader(headerCellStyle, sheet, excelHheaderNames, cellCount);

        CellStyle columnCellStyle = setFontAlignAndBorder(workbook, HSSFCellStyle.ALIGN_CENTER, (short) 10, hasBorder);
        createColumn(columnCellStyle, sheet, exportMsgList, excelCloumnNames, cellCount);

        FileOutputStream fos1 = new FileOutputStream(new File(savePath));
        workbook.write(fos1);
        fos1.close();
    }

    private static void createColumn(CellStyle cellStyle, HSSFSheet sheet, List<Map<String, Object>> exportMsgList, List<String> exportMsgNameList, int cellCount) {
        for (int i = 2; i < exportMsgList.size() + 2; i++) {
            HSSFRow row2 = sheet.createRow(i);
            for (int j = 0; j < cellCount; j++) {
                String cellValue = "";
                Object cellValueObject = exportMsgList.get(i - 2).get(exportMsgNameList.get(j));
                if (cellValueObject != null) {
                    cellValue = cellValueObject.toString();
                }
                createCell(row2, j, cellStyle, cellValue);
            }
        }
    }

    private static void createHeader(CellStyle cellStyle, HSSFSheet sheet, List<String> headerList, int cellCount) {
        HSSFRow rowHeader = sheet.createRow(1);
        for (int i = 0; i < cellCount; i++) {
            createCell(rowHeader, i, cellStyle, headerList.get(i));
        }
    }

    private static void createTitle(CellStyle cellStyle, HSSFSheet sheet, String excelTitle, int cellCount) {
        for (int i = 0; i < cellCount; i++) {
            sheet.setColumnWidth(i, 5000);
        }

        HSSFRow row0 = sheet.createRow(0);
        createCell(row0, 0, cellStyle, excelTitle);
        for (int i = 1; i < cellCount; i++) {
            createCell(row0, i, cellStyle, "");
        }
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, cellCount - 1));
    }

    /**
     * 创建普通单元格
     *
     * @param row       自定的行
     * @param column    指定的列
     * @param cellStyle cell样式
     * @param value     cell的值
     */
    private static void createCell(HSSFRow row, int column, CellStyle cellStyle, String value) {
        HSSFCell cell = row.createCell(column);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    /**
     * Description: 添加有边框的格子， 字体我默认用的宋体
     *
     * @param wb         :  工作表
     * @param align      :  字体的对其方式,如：HSSFCellStyle.ALIGN_CENTER
     * @param fontHeight : 字体的高度
     */
    private static CellStyle setFontAlignAndBorder(Workbook wb, short align, short fontHeight, boolean hasBorder) {
        CellStyle style = wb.createCellStyle();

        Font font = wb.createFont();
        font.setFontHeightInPoints(fontHeight);
        font.setFontName("宋体");
        style.setFont(font);

        if (hasBorder) {
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBottomBorderColor(HSSFColor.BLACK.index);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setLeftBorderColor(HSSFColor.BLACK.index);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setRightBorderColor(HSSFColor.BLACK.index);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setTopBorderColor(HSSFColor.BLACK.index);
        }

        style.setAlignment(align);
        return style;
    }

    public static void main(String[] args) {
        String savePath = new StringBuilder().append("H:\\000\\").append(UUID.randomUUID().toString()).append("用户信息.xls").toString();

        String excelTitle = "用户信息";

        List<Map<String, Object>> exportMsgList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Map<String, Object> exportMsgMap = new HashMap<>();
            exportMsgMap.put("userid", i);
            exportMsgMap.put("username", i + "aa");
            exportMsgMap.put("nickname", i + "bb");
            exportMsgMap.put("employeeid", i + "cc");
            exportMsgMap.put("imeiid", i + 1);
            exportMsgList.add(exportMsgMap);
        }

        List<String> cloumnNameList = new ArrayList<>();
        cloumnNameList.add("userid");
        cloumnNameList.add("username");
        cloumnNameList.add("nickname");
        cloumnNameList.add("employeeid");
        cloumnNameList.add("imeiid");

        List<String> headerNameList = new ArrayList<>();
        headerNameList.add("用户id");
        headerNameList.add("用户名称");
        headerNameList.add("用户昵称");
        headerNameList.add("雇员号");
        headerNameList.add("序列号");

        try {
            ExcelReportUtil.generateExportUsersExcel(exportMsgList, headerNameList, cloumnNameList, excelTitle, savePath);
            Runtime.getRuntime().exec("cmd /c start explorer H:\\000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
