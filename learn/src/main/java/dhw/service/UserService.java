package dhw.service;

import dhw.bean.User;
import dhw.exception.MyException;

public interface UserService {
	/**
	 * 
	 * @description 根据用户名密码查询User
	 * @param userName
	 * @param password
	 * @return   
	 * @return User    返回类型 
	 * @throws 
	 * @author 段华微
	 * @date 2017年11月27日 下午7:36:09
	 */
	public User getUserByUserNameAndPwd(String userName,String password) throws MyException ;
	/**
	 * 
	 * @description 添加用户
	 * @param userName
	 * @param password
	 * @throws MyException   
	 * @return void    返回类型 
	 * @throws 
	 * @author 段华微
	 * @date 2017年11月29日 上午11:21:25
	 */
	public void addUser(String userName, String password) throws MyException ;
}
