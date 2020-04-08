package com.database.multi.datasource.controller;

import com.database.multi.datasource.entity.User;
import com.database.multi.datasource.mapper.UserMapper;
import com.imooc.helloworld.autoconfigure.SwaggerProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Yu
 * @since 2020/4/5
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口", description = "提供用户相关的Rest API")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @ApiOperation("查找用户接口")
    @GetMapping("/{name}/list")
    public List<User> findAll(@PathVariable("name") @ApiParam(name="name", value = "数据库名称", required = true, defaultValue = "master") String name) {
        if(name.equals("master")){
            return userMapper.queryAllWithMaster();
        }else{
            return userMapper.queryAllWithSlave();
        }
    }

}
