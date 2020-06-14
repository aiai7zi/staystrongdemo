package com.staystrong.entity.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.staystrong.entity.vo.UserVo;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user")
public class UserDto implements Serializable {
    @TableId
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
