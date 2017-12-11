package dhw.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: PayOrderStatusEnum
 * @Date 2017/11/22 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
@Table(name="user")
public class User implements Serializable{

    /**
	 * 2017年11月27日 下午8:06:06 段华微  
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name")
    private String name;
	@Column(name="age")
    private Integer age;
	@Column(name="featureId")
	private Integer featureId;
    public Integer getFeatureId() {
		return featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}
	@Transient
	private FeatureInfo feature;
	@Column(name="userName")
    private String userName;
	@Column(name="password")
    private String password;

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FeatureInfo getFeature() {
        return feature;
    }

    public void setFeature(FeatureInfo feature) {
        this.feature = feature;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", feature=" + feature + "]";
	}

	public User() {
		super();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

//    @Override
//    public String toString() {
//        return MoreObjects.toStringHelper(this)
//                .add("id", id)
//                .add("name", name)
//                .add("age", age)
//                .add("feature", feature)
//                .toString();
//    }
    
}
