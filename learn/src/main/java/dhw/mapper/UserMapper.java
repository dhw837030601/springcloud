package dhw.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import dhw.bean.User;
import dhw.mybatis.MyMapper;

/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: PayOrderStatusEnum
 * @Date 2017/11/22 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
//@Mapper
public interface UserMapper extends MyMapper<User>{
	/**
	 * 
	 * @description 根据名字查询用户
	 * @param name
	 * @return   
	 * @return User    返回类型 
	 * @throws 
	 * @author 段华微
	 * @date 2017年11月28日 下午2:16:54
	 */
    @Select("select * from user where name=#{name}")
    User getUserByName(@Param("name")String name);
    /**
     *
     * @description 根据id查询用户信息
     * @param id
     * @return   User 返回类型
     * @author 段华微
     * @date 2017-11-27 15:45:39
     */
//    @Select("select o.id,o.name,o.age,o.featureId as feature.id from user o left join feature on feature.id=o.featureId  where o.id=#{id}")
    //@Select("select o.id,o.name,o.age,feature.* from user o left join feature on feature.id=o.featureId  where o.id=1")
    User selectById(@Param("id")Integer id);
    /**
     * 
     * @description 根据用户名和密码查用户
     * @param userName
     * @param password
     * @return   
     * @return User    返回类型 
     * @throws 
     * @author 段华微
     * @date 2017年11月28日 下午2:21:43
     */
    @Select("select * from user where userName=#{userName} and password=#{password}")
    User getUserByUserNameAndPwd(@Param("userName")String userName,@Param("password")String password);
    /**
     * 
     * @description 根据用户名查用户
     * @param userName
     * @return   
     * @return User    返回类型 
     * @throws 
     * @author 段华微
     * @date 2017年11月28日 下午2:22:02
     */
    @Select("select * from user where userName=#{userName}")
    User getUserByUserName(@Param("userName")String userName);
    
    @Insert("insert into user (userName,password) values(#{userName},#{password})")
    Integer insertUser(@Param("userName")String userName,@Param("password")String password);
	
}
