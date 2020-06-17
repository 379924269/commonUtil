package com.dnp.commonUtil.org;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author huazai
 * @description
 * @date 2020/6/17
 */
@Data
@Builder
public class Org {
    /**
     * id
     */
    public Integer id;
    /**
     * 名称
     */
    public String name;
    /**
     * 父id ，根节点为0
     */
    public Integer parentId;
    /**
     * 子节点信息
     */
    public List<Org> childList;

    public Org(Integer id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Org(Integer id, String name, Integer parentId, List<Org> childList) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
    }
}
