package dhw.mapper;

import dhw.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: PayOrderStatusEnum
 * @Date 2017/11/22 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where name=#{name}")
    User getUserByName(@Param("name")String name);
}
