package com.dnp.commonUtil.org;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huazai
 * @description
 * @date 2020/6/17
 */
public class OrgTreeUtilTest {
    //模拟从数据库查询出来
    List<Org> OrgList = Arrays.asList(
            new Org(1, "根节点", 0),
            new Org(2, "子节点1", 1),
            new Org(3, "子节点1.1", 2),
            new Org(4, "子节点1.2", 2),
            new Org(5, "根节点1.3", 2),
            new Org(6, "根节点2", 1),
            new Org(7, "根节点2.1", 6),
            new Org(8, "根节点2.2", 6),
            new Org(9, "根节点2.2.1", 7),
            new Org(10, "根节点2.2.2", 7),
            new Org(11, "根节点3", 1),
            new Org(12, "根节点3.1", 11)
    );

    @Test
    public void getOrgTreeData() {
        List<Org> orgList = OrgTreeUtil.generateOrgTreeData(OrgList, 1);
        System.out.println("xx1 = " + JSON.toJSON(orgList).toString());
    }

    @Test
    public void getAllChildOrgInfo() {
        List<Org> orgList = OrgTreeUtil.getAllChildOrg(OrgList, 1);
        System.out.println("xx = " + JSON.toJSON(orgList).toString());
    }

    @Test
    public void getAllChildOrgIdInfo() {
        //用逗号隔开多个部门id
        List<Org> orgList = OrgTreeUtil.getAllChildOrg(OrgList, 1);
        String orgIdsString = orgList.stream().map(org -> String.valueOf(org.getId())).collect(Collectors.joining(","));
        System.out.println("orgIdsString = " + orgIdsString);
    }
}
