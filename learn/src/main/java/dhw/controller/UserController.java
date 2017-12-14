package dhw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dhw.bean.User;
import dhw.consts.ErrorEnum;
import dhw.controller.base.BaseController;
import dhw.exception.MyException;
import dhw.mapper.UserMapper;
import dhw.service.UserService;
import dhw.utils.AssembleErrJsonUtil;

/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: PayOrderStatusEnum
 * @Date 2017/11/22 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
@Controller
public class UserController extends BaseController{
	Logger logger = LoggerFactory.getLogger(UserController.class);
	private String SUCCESS = "1";
	private String FAILURE = "0";
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/user")
    public String user(){
        User user = userMapper.getUserByName("测试");
        User newUser = userMapper.selectById(1);
        System.out.println(newUser.toString());

        return user.getName()+"---------------"+user.getAge();
    }
    /**
     * 
     * @description 跳转登录页
     * @return   
     * @return String    返回类型 
     * @throws 
     * @author 段华微
     * @date 2017年11月27日 下午8:31:22
     */
    @RequestMapping("/toLogin")
    public String toLogin() {

        return "/login";
    }
    /**
     * 
     * @description 登录
     * @param userName
     * @param password
     * @return   
     * @return String    返回类型 
     * @throws 
     * @author 段华微
     * @date 2017年11月27日 下午8:31:13
     */
    @ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value="userName")String userName,@RequestParam(value="password")String password,
			HttpServletRequest request){
		User user = null;
		try {
			user = userService.getUserByUserNameAndPwd(userName, password);
		} catch (MyException e) {
			e.printStackTrace();
			logger.error(e.getErrorMsg().getEmsg());
			return AssembleErrJsonUtil.AssembleErr2Json(ErrorEnum.FAILD);
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return AssembleErrJsonUtil.AssembleErr2Json(ErrorEnum.SUCCESS);
    }
	/**
     * 
     * @description 跳转index页面
     * @return   
     * @return String    返回类型 
     * @throws 
     * @author 段华微
     * @date 2017年11月27日 下午8:37:19
     */
    @RequestMapping("/index")
    public String index(Model m) {
    	m.addAttribute("productList", "");
        return "/index";
    }
    /**
     * 
     * @description 跳转注册页面
     * @return   
     * @return String    返回类型 
     * @throws 
     * @author 段华微
     * @date 2017年11月27日 下午8:37:19
     */
    @RequestMapping("/toRegister")
    public String toRegister(HttpServletRequest request,HttpServletResponse response) {
    	return "/a";
    }
    @ResponseBody//, method = RequestMethod.POST
    @RequestMapping("/register")
    public String register(
    		@RequestParam(value="userName")String userName,
    		@RequestParam(value="password")String password,
    		@RequestParam(value="code")String code,
			HttpServletRequest request){
    	if(StringUtils.isBlank(code)){
    		return AssembleErrJsonUtil.AssembleErr2Json(ErrorEnum.FAILD);
    	}
    	String sessionStr = (String)request.getSession().getAttribute("imgvcode");
    	if(!code.toLowerCase().equals(sessionStr)){
    		logger.info("验证码错误");
    		return AssembleErrJsonUtil.AssembleErr2Json(ErrorEnum.ERR_VERIFI_CODE_IS_WRONG);
    	}
    	try {
			userService.addUser(userName,password);
		} catch (MyException e) {
			e.printStackTrace();
			return AssembleErrJsonUtil.AssembleErr2Json(e.getErrorMsg());
		}
    	return AssembleErrJsonUtil.AssembleErr2Json(ErrorEnum.SUCCESS);
    }
    
}
