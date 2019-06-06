package com.dnp.commonUtil;

import org.junit.Test;

/**
 * Created by huazai on 2019/5/22.
 */
public class GeneratePermissionInfoTest {

    @Test
    public void GenerateDBInsert() throws Exception {
       new GeneratePermissionInfo().genDbPermissionInserSql("ms_ptt",10, 1, "new-ptt");
    }

    @Test
    public void GenerateTableInsert() throws Exception {
        new GeneratePermissionInfo().genTablePermissionInserSql("zuulRoute",290, 1, "ptt");
    }
}
