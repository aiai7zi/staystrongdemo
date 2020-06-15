package com.staystrong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.staystrong.entity.dto.UserDto;
import com.staystrong.mapper.IUserMapper;
import com.staystrong.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tanji
 * @since 2020-04-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, UserDto> implements IUserService {


    @Override
    public List<UserDto> foundAllUser() {
        return baseMapper.foundAllUser();
    }
}
