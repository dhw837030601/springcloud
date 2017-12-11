package dhw.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dhw.bean.User;
import dhw.consts.ErrorEnum;
import dhw.exception.MyException;
import dhw.mapper.UserMapper;
import dhw.service.UserService;
import dhw.utils.MD5Utils;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	/**
	 * 根据用户名密码查询用户
	 */
	@Override
	public User getUserByUserNameAndPwd(String userName, String password) throws MyException {
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)){
			throw new MyException(ErrorEnum.ERR_PARM_IS_NULL);
		}
		User user = userMapper.getUserByUserName(userName);
		if(user == null){
			throw new MyException(ErrorEnum.ERR_USER_IS_NOT_FOUND);
		}
		String dbPwd = user.getPassword();
		Boolean rtn = MD5Utils.VerifyPassWord(password, dbPwd);
		if(!rtn){
			throw new MyException(ErrorEnum.ERR_PASSWORD_IS_WRONG);
		}
		return user;
	}
	/**
	 * 添加用户
	 */
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	@Override
	public void addUser(String userName, String password) throws MyException {
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password) ){
			throw new MyException(ErrorEnum.ERR_PARM_IS_NULL);
		}
		User user = userMapper.getUserByUserName(userName);
		if(user!=null){
			throw new MyException(ErrorEnum.ERR_USERNAME_HAS_EXISTS);
		}
		try {
			password = MD5Utils.encodeByMd5AndSalt(password);
			User newUser = new User();
			newUser.setUserName(userName);
			newUser.setPassword(password);
			userMapper.insertSelective(newUser);
			//userMapper.insertUser(userName, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyException(ErrorEnum.ERR_REGIST_USER_FAILD);
		}
		
		
	}
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
}
