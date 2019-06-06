package com.cn.huazai.modular.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.huazai.modular.dao.UsersMapper;
import com.cn.huazai.modular.entity.Users;
import com.cn.huazai.modular.service.UsersService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author huazai
 * @since 2019-05-27
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
