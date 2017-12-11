package dhw.bean;

import java.io.Serializable;

/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: PayOrderStatusEnum
 * @Date 2017/11/27 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
public class FeatureInfo implements Serializable {
    private Integer id;
    private Integer sex;
    private Integer isGoodMan;

    public Integer getSex() {
        return sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsGoodMan() {
        return isGoodMan;
    }

    public void setIsGoodMan(Integer isGoodMan) {
        this.isGoodMan = isGoodMan;
    }

	@Override
	public String toString() {
		return "FeatureInfo [id=" + id + ", sex=" + sex + ", isGoodMan=" + isGoodMan + "]";
	}

   
}
