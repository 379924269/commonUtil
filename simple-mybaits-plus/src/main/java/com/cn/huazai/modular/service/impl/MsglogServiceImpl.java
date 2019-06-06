package com.cn.huazai.modular.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.huazai.modular.dao.MsglogMapper;
import com.cn.huazai.modular.entity.Msglog;
import com.cn.huazai.modular.service.MsglogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息记录，新版本已经不再需要 服务实现类
 * </p>
 *
 * @author huazai
 * @since 2019-05-27
 */
@Service
public class MsglogServiceImpl extends ServiceImpl<MsglogMapper, Msglog> implements MsglogService {

}
