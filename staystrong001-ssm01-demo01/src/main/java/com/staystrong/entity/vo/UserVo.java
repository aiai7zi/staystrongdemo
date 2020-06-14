package com.staystrong.entity.vo;

import com.staystrong.entity.dto.UserDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {
    private Long userId;
    private String userName;
    private String password;
    private String salt;


}
