package com.staystrong.entity.dto;

import com.staystrong.entity.vo.UserVo;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Long userId;
    private String userName;
    private String password;
    private String salt;

    public UserVo getUserVo(){
        UserVo vo=new UserVo();
        vo.setUserId(this.getUserId());
        vo.setUserName(this.getUserName());
        vo.setPassword(this.getPassword());
        vo.setSalt(this.getSalt());
        return vo;
    }

}
