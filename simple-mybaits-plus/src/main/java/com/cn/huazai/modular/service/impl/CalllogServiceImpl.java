package com.cn.huazai.modular.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.huazai.modular.dao.CalllogMapper;
import com.cn.huazai.modular.entity.Calllog;
import com.cn.huazai.modular.service.CalllogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通话记录 服务实现类
 * </p>
 *
 * @author huazai
 * @since 2019-05-27
 */
@Service
public class CalllogServiceImpl extends ServiceImpl<CalllogMapper, Calllog> implements CalllogService {

}
