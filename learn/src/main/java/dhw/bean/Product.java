package dhw.bean;

import java.io.Serializable;
/**
 * 
 * @description 商品实体类
 * @ClassName: Product
 * @version V1.0
 * @author 段华微
 * @Date 2017年12月15日 上午11:10:54
 * Copyright(c) 2015 www.aiwue.com  All rights reserved
 *
 */
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="product")
public class Product implements Serializable{

	/**
	 * 2017年12月15日 上午11:10:46 段华微  
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;//商品名称
	
	@Column(name="normalPrice")
	private BigDecimal normalPrice;//正常价格
	
	@Column(name="memberPrice")
	private BigDecimal memberPrice;//会员价格
	
	@Column(name="isShow")
	private Integer isShow;//是否显示
	
	@Column(name="pic")
	private String pic;//图片
	
	@Column(name="description")
	private String description;//描述
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getNormalPrice() {
		return normalPrice;
	}
	public void setNormalPrice(BigDecimal normalPrice) {
		this.normalPrice = normalPrice;
	}
	public BigDecimal getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}
	public Integer getIsShow() {
		return isShow;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
