package com.staystrong.controller;


import com.staystrong.entity.dto.UserDto;
import com.staystrong.entity.vo.UserVo;
import com.staystrong.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tanji
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/user")
public class UserController {
     private IUserService iUserService;
     @Autowired
    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }
  @RequestMapping("/foundAll")
  public List<UserVo> foundAllUser(){
      List<UserVo> list=new ArrayList<UserVo>();
      List<UserDto> userDtos = iUserService.foundAllUser();
      for (UserDto userDto : userDtos) {
          list.add(userDto.getUserVo());
      }
      return list;
  }

}

