package com.database.multi.datasource.mapper;

import com.database.multi.datasource.annotation.DataSource;
import com.database.multi.datasource.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yu
 * @since 2020/4/5
 */
@Mapper
public interface UserMapper {

    @Select("select u.id, u.name from t_user u")
    @DataSource(name = "master_test")
    List<User> queryAllWithMaster();

    /**
     *
     * @return
     */
    @DataSource(name = "slave_test")
    @Select("select u.id, u.name from t_user u")
    List<User> queryAllWithSlave();
}
