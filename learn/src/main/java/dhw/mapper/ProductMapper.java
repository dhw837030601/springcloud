package dhw.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import dhw.bean.Product;
import dhw.mybatis.MyMapper;

public interface ProductMapper extends MyMapper<Product>{
	@SelectProvider(type=ProductSqlProvider.class,method="getProductListByConditions")
	List<Product> getProductListByConditions(Map<String,Object> parms);
}
