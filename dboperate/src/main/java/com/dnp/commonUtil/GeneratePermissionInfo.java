package com.dnp.commonUtil;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 自动生成权限表信息
 *
 * @Author: 华仔
 * @Date: 2019/5/22
 */
@Log
public class GeneratePermissionInfo {

    /**
     * Description: 生成DB权限插入sql
     *
     * @param dbName                    : 服务数据库名称
     * @param PermissionAutoIncrementId : 权限表当前的自增id, 最小从10开始，10以前的是留给服务的
     * @param serviceId                 : 服务id，相当于总权限,我留了10个服务，可以是1-10， 根据权限表来看
     */
    public void genDbPermissionInserSql(String dbName, int PermissionAutoIncrementId, int serviceId) throws Exception {
        for (Permission per : generatePermissionInfo(dbName, PermissionAutoIncrementId, serviceId)) {
            getInsertSql(per);
        }
    }

    /**
     * Description: 生成单个表权限插入sql
     *
     * @param tableName                 : 表名称
     * @param PermissionAutoIncrementId : 权限表当前的自增id, 最小从10开始，10以前的是留给服务的
     * @param serviceId                 : 服务id，相当于总权限,我留了10个服务，可以是1-10， 根据权限表来看
     */
    public void genTablePermissionInserSql(String tableName, int PermissionAutoIncrementId, int serviceId) throws Exception {
        for (Permission per : generateTablePermissionInfo(tableName, PermissionAutoIncrementId, serviceId)) {
            getInsertSql(per);
        }
    }

    /**
     * Description:
     *
     * @param autoIncrementId : 表当前的自增id, 最小从10开始，10以前的是留给服务的
     * @param serviceId       : 服务id，相当于总权限
     * @return : java.util.List<com.dnp.commonUtil.Permission>
     * @
     */
    private List<Permission> generatePermissionInfo(String dbName, int autoIncrementId, int serviceId) throws Exception {
        List<String> allTableName = AutoDocumentEntity.getAllTableName(dbName);
        return getPermissions(autoIncrementId, serviceId, allTableName);
    }

    private List<Permission> generateTablePermissionInfo(String tableName, int autoIncrementId, int serviceId) throws Exception {
        List<String> allTableName = new ArrayList<>();
        allTableName.add(tableName);
        return getPermissions(autoIncrementId, serviceId, allTableName);
    }

    private List<Permission> getPermissions(int autoIncrementId, int serviceId, List<String> allTableName) {
        List<Permission> permissionList = new ArrayList<>();
//        自增id
        int id = autoIncrementId;

        for (String anAllTableName : allTableName) {
            Permission allper = new Permission();
            Permission findper = new Permission();
            Permission addper = new Permission();
            Permission updateper = new Permission();
            Permission delper = new Permission();

            allper.setId(id + 1);
            allper.setName(anAllTableName + "权限管理");
            allper.setMethod("");
            allper.setUrl(anAllTableName + "/**");
            allper.setPid(serviceId);
            allper.setCurrentTime(System.currentTimeMillis());

            findper.setId(id + 2);
            findper.setName(anAllTableName + "查看");
            findper.setMethod("get");
            findper.setUrl(anAllTableName + "/");
            findper.setPid(id + 1);
            findper.setCurrentTime(System.currentTimeMillis());

            updateper.setId(id + 3);
            updateper.setName(anAllTableName + "修改");
            updateper.setMethod("put");
            updateper.setUrl(anAllTableName + "/");
            updateper.setPid(id + 1);
            updateper.setCurrentTime(System.currentTimeMillis());

            addper.setId(id + 4);
            addper.setName(anAllTableName + "添加");
            addper.setMethod("post");
            addper.setUrl(anAllTableName + "/");
            addper.setPid(id + 1);
            addper.setCurrentTime(System.currentTimeMillis());

            delper.setId(id + 5);
            delper.setName(anAllTableName + "删除");
            delper.setMethod("delete");
            delper.setUrl(anAllTableName + "/");
            delper.setPid(id + 1);
            delper.setCurrentTime(System.currentTimeMillis());

            permissionList.add(allper);
            permissionList.add(findper);
            permissionList.add(updateper);
            permissionList.add(addper);
            permissionList.add(delper);
            id += 5;
        }
        return permissionList;
    }

    private void getInsertSql(Permission per) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO `resource`(`id`, `name`, `url`, `pid`,`create_time`, `method`) VALUES (");
        stringBuilder.append(per.getId());
        stringBuilder.append(",");
        stringBuilder.append("'").append(per.getName()).append("'");
        stringBuilder.append(",");
        stringBuilder.append("'").append(per.getUrl()).append("'");
        stringBuilder.append(",");
        stringBuilder.append(per.getPid());
        stringBuilder.append(",");
        stringBuilder.append(per.getCurrentTime());
        stringBuilder.append(",");
        stringBuilder.append("'").append(per.getMethod()).append("'");
        stringBuilder.append(");");
        System.out.println(stringBuilder.toString());
    }
}
