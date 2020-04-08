package com.database.multi.datasource.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Yu
 * @since 2020/4/5
 */
@Data
@ApiModel("用户实体:User")
public class User implements Serializable {

    private static final long serialVersionUID = 7603577383307817916L;
    /**
     * user id
     */
    @ApiModelProperty("用户id")
    private Integer id;
    /**
     * user name
     */
    @ApiModelProperty("用户姓名")
    private String name;
}
