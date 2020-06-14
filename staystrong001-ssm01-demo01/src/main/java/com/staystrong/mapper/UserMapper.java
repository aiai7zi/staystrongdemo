package com.staystrong.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.staystrong.entity.dto.UserDto;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tanji
 * @since 2020-04-21
 */
public interface UserMapper extends BaseMapper<UserDto> {
    List<UserDto> foundAllUser();
}
