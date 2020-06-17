package com.dnp.commonUtil.org;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author huazai
 * @description
 * @date 2020/6/17
 */
public class OrgTreeUtilTest {
    @Test
    public void getOrgTreeData() {
        //模拟从数据库查询出来
        List<Org> OrgList = Arrays.asList(
                new Org(1,"根节点",0),
                new Org(2,"子节点1",1),
                new Org(3,"子节点1.1",2),
                new Org(4,"子节点1.2",2),
                new Org(5,"根节点1.3",2),
                new Org(6,"根节点2",1),
                new Org(7,"根节点2.1",6),
                new Org(8,"根节点2.2",6),
                new Org(9,"根节点2.2.1",7),
                new Org(10,"根节点2.2.2",7),
                new Org(11,"根节点3",1),
                new Org(12,"根节点3.1",11)
        );

        System.out.println("OrgList = " + OrgTreeUtil.generateOrgTreeData(OrgList, 0));
    }
}
