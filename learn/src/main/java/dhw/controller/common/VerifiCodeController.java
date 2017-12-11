package dhw.controller.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dhw.utils.VerifyCodeUtils;

@Controller
public class VerifiCodeController {
	Logger logger = LoggerFactory.getLogger(VerifiCodeController.class);
	
	@RequestMapping("/getImgCode")
	public void getImgCode(HttpServletRequest request,HttpServletResponse response){
		logger.info("进入userController发送图片验证码sendImgCode方法.....");
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
       
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        request.getSession().removeAttribute("imgvcode");
        request.getSession().setAttribute("imgvcode", verifyCode.toLowerCase());  
        //生成图片  
        int w = 104, h = 34;  
        try {
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("进入userController发送图片验证码sendImgCode方法.....生成图片验证码错误");
		}  
        logger.info("进入userController发送图片验证码sendImgCode方法.....生成图片验证码成功");
	}
	/**
	 * 
	 * @description 验证验证码是否正确
	 * @param request
	 * @param code
	 * @return   
	 * @return String    返回类型 
	 * @throws 
	 * @author 段华微
	 * @date 2017年11月28日 下午4:19:42
	 */
	@ResponseBody
	@RequestMapping("/verifiTheCode")
	public String getImgCode(HttpServletRequest request,String code){
		logger.info("进入userController发送图片验证码sendImgCode方法.....");
        String sessionStr = (String)request.getSession().getAttribute("imgvcode");
        if(StringUtils.isBlank(code) || !code.toLowerCase().equals(sessionStr)){
        	return "0";
        }
        return "1";
	}
}
