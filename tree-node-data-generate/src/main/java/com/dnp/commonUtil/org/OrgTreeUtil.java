package com.dnp.commonUtil.org;

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
     * description: 获取自定义的pid的所有子节点，比如部门可以穿pid为0
     *
     * @param orgList  : 所有部门列表信息
     * @param parentId : pid节点
     * @return : java.util.List<com.dnp.commonUtil.org.Org> 返回所有pid节点及子节点
     */
    public static List<Org> generateOrgTreeData(List<Org> orgList, Integer parentId) {
        //获取父节点
        List<Org> collect = orgList.stream().filter(m -> m.getParentId() == parentId).map(
                (m) -> {
                    m.setChildList(getChildrens(m, orgList));
                    return m;
                }
        ).collect(Collectors.toList());

        return collect;
    }

    /**
     * description: 获取指定部门的所有子部门信息
     *
     * @param all   : 所有部门信息
     * @param orgId :  制定部门id
     * @return : java.util.List<com.dnp.commonUtil.org.Org>
     */
    public static List<Org> getAllChildOrg(List<Org> all, int orgId) {
        List<Org> children = all.stream()
                .filter(item -> item.parentId == orgId)
                .collect(Collectors.toList());
        List<Org> subChildren = children.stream()
                .map(child -> getAllChildOrg(all, child.id))
                .flatMap(List::stream)
                .collect(Collectors.toList());
        children.addAll(subChildren);
        return children;
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
