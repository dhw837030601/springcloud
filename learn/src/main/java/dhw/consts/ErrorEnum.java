package dhw.consts;

import java.text.SimpleDateFormat;
import java.util.Date;

public enum ErrorEnum {
	
	SUCCESS("1","操作成功"),
	FAILD("0","失败"),
	
	ERR_PARM_IS_NULL("2","参数为空！"),
	ERR_USERNAME_HAS_EXISTS("3","用户名已存在！"),
	ERR_USER_IS_NOT_FOUND("4","用户不存在！"),
	ERR_PASSWORD_IS_WRONG("5","密码错误！"),
	ERR_VERIFI_CODE_IS_WRONG("6","验证码错误！"),
	ERR_REGIST_USER_FAILD("7","注册失败！"),
	TEST("0","失败");
	private String ecode;
	private String emsg;
	
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getEmsg() {
		return emsg;
	}
	public void setEmsg(String emsg) {
		this.emsg = emsg;
	}
	private ErrorEnum(String ecode, String emsg) {
		this.ecode = ecode;
		this.emsg = emsg;
	}
	public static String getExtStr(Integer ecode){
		if(ecode == null){
			return null;
		}
		for (ErrorEnum c : ErrorEnum.values()) {
			if (c.getEcode().equals(ecode)) {
				return c.emsg;
			}
		}
		return "----";
	}
	public static void main(String[] args) {
		System.out.println("//自动生成对应的js代码 ErrorEnum.js...");
		System.out.println("//由ErrorEnum.java自动生成，请勿自己改动，如需改动，请先改动ErrorEnum.java后，自动生成...");
		Date myDate = new Date();
		System.out.println("//" +new SimpleDateFormat("yyyy-MM-dd").format(myDate));

		System.out.println("var PayOrderStatusEnum = {");
		for(ErrorEnum s : ErrorEnum.values()){
			System.out.println("    "+s.name() +" : {ecode: '"+s.ecode+"', emsg: '"+ s.emsg+"'},");
		}

		System.out.println("};");
		/*System.out.println("function getNameByValue(ecode){");
		System.out.println("    for(var enum in PayOrderStatusEnum){");
		System.out.println("        if (enum.ecode == ecode)");
		System.out.println("            return enum.name;");
		System.out.println("    }");
		System.out.println("    return '';");
		System.out.println("};");*/

	}
}
