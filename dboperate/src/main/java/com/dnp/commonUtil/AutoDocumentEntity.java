package com.dnp.commonUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * 读取mysql某数据库下表的注释信息
 *
 * @author xxx
 */
public class AutoDocumentEntity {
    public static Connection getMySQLConnection(String dbName) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, "root", "123456");
        return conn;
    }

    /**
     * 获取当前数据库下的所有表名称
     *
     * @return
     * @throws Exception
     */
    public static List<String> getAllTableName(String dbName) throws Exception {
        List<String> tables = new ArrayList<String>();
        Connection conn = getMySQLConnection(dbName);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW TABLES ");
        while (rs.next()) {
            String tableName = rs.getString(1);
            tables.add(handleColName(tableName));
        }
        rs.close();
        stmt.close();
        conn.close();
//		tables.add("auditor_audit_proxy_query");
        return tables;
    }

    /**
     * 获得某表的建表语句
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    public static Map<String, String> getCommentByTableName(List<String> tableName, String dbName) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        Connection conn = getMySQLConnection(dbName);
        Statement stmt = conn.createStatement();
        for (int i = 0; i < tableName.size(); i++) {
            String table = tableName.get(i);
            ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + table);
            if (rs != null && rs.next()) {
                String createDDL = rs.getString(2);
                String comment = parse(createDDL);
                map.put(table, comment);
            }
            rs.close();
        }
        stmt.close();
        conn.close();
        return map;
    }

    /**
     * 获得某表中所有字段的注释
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    public static void getColumnCommentByTableName(List<String> tableName, String dbName) throws Exception {
//		Map map = new HashMap();
        Connection conn = getMySQLConnection(dbName);
        Statement stmt = conn.createStatement();
        for (int i = 0; i < tableName.size(); i++) {
            String table = (String) tableName.get(i);
            ResultSet rs = stmt.executeQuery("show full columns from " + table);
            System.out.println("【" + table + "】");
            // if (rs != null && rs.next()) {
            // map.put(rs.getString("Field"), rs.getString("Comment"));
            while (rs.next()) {
                // System.out.println("字段名称：" + rs.getString("Field") + "\t"+
                // "字段注释：" + rs.getString("Comment") );
                System.out.println("\"" + rs.getString("Field") + "\"" + ":" + sqlType2JavaType(rs.getString("Type")) + "  //" + rs.getString("Comment"));
            }
            // }
            rs.close();
        }
        stmt.close();
        conn.close();
        // return map;
    }

    private static String sqlType2JavaType(String sqlType) {
        if (sqlType.contains("bit")) {
            return "bool";
        } else if (sqlType.contains("tinyint")) {
            return "byte";
        } else if (sqlType.contains("smallint")) {
            return "short";
        } else if (sqlType.contains("int")) {
            return "int";
        } else if (sqlType.contains("bigint")) {
            return "long";
        } else if (sqlType.contains("float")) {
            return "float";
        } else if (sqlType.contains("decimal") || sqlType.contains("numeric") || sqlType.contains("real")) {
            return "double";
        } else if (sqlType.contains("money") || sqlType.contains("smallmoney")) {
            return "double";
        } else if (sqlType.contains("varchar") || sqlType.contains("char") || sqlType.contains("nvarchar") || sqlType.contains("nchar")) {
            return "String";
        } else if (sqlType.contains("datetime")) {
            // return "Date";
            return "String";
        } else if (sqlType.contains("image")) {
            return "Blob";
        } else if (sqlType.contains("text")) {
            // return "Clob";
            return "String";
        } else if (sqlType.contains("timestamp")) {
            return "String";
        }
        return null;
    }

    /**
     * 返回注释信息
     *
     * @param all
     * @return
     */

    public static String parse(String all) {
        String comment = null;
        int index = all.indexOf("COMMENT='");
        if (index < 0) {
            return "";
        }
        comment = all.substring(index + 9);
        comment = comment.substring(0, comment.length() - 1);
        return comment;
    }

    /**
     * 把用下滑新隔开的但是首字母大写
     *
     * @param colName 列字段名字
     * @return
     */
    public static String handleColName(String colName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < colName.split("_").length; i++) {
            if (colName.split("_").length == 1) {
                stringBuilder.append(colName.split("_")[0]);
            } else {
                if (i == 0) {
                    stringBuilder.append(colName.split("_")[0]);
                } else {
                    stringBuilder.append(initcap(colName.split("_")[i]).toString());
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 把输入字符串的首字母改成大写
     *
     * @param str 字符串
     * @return string
     */
    private static String initcap(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}