package dhw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 段华微
 * @version V1.0
 * @description 描述
 * @ClassName: Application
 * @Date 2017/11/22 Copyright(c) 2015 www.wallet.com All rights
 * reserved
 */
@MapperScan("dhw.mapper")
@SpringBootApplication 
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
