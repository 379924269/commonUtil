package com.dnp.commonUtil.org;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author huazai
 * @description
 * @date 2020/6/17
 */
public class OrgTreeUtil {

    /**
     * description: 获取自定pid的子节点
     * @param orgList :
     * @param parentId :
     * @return : java.lang.String
     */
    public static String generateOrgTreeData(List<Org> orgList, Integer parentId) {
        //获取父节点
        List<Org> collect = orgList.stream().filter(m -> m.getParentId() == parentId).map(
                (m) -> {
                    m.setChildList(getChildrens(m, orgList));
                    return m;
                }
        ).collect(Collectors.toList());

        return JSON.toJSON(collect).toString();
    }

    /**
     * 递归查询子节点
     *
     * @param root 根节点
     * @param all  所有节点
     * @return 根节点信息
     */
    private static List<Org> getChildrens(Org root, List<Org> all) {
        List<Org> children = all.stream()
                .filter(m -> Objects.equals(m.getParentId(), root.getId()))
                .map(m -> {
                            m.setChildList(getChildrens(m, all));
                            return m;
                        }
                ).collect(Collectors.toList());
        return children;
    }

}
