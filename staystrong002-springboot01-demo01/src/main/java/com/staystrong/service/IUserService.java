package com.staystrong.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.staystrong.entity.dto.UserDto;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tanji
 * @since 2020-04-21
 */
public interface IUserService extends IService<UserDto> {
    List<UserDto> foundAllUser();
}
