package com.dnp.commonUtil;

import org.junit.Test;

import java.util.List;

/**
 * Created by huazai on 2019/5/22.
 */
public class GeneratePermissionInfoTest {

    @Test
    public void GenerateInsert() throws Exception {
       new GeneratePermissionInfo().genPermissionInserSql("ms-pay",280, 3);
    }
}
