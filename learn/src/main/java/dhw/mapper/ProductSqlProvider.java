package dhw.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {
	public String getProductListByConditions(Map<String, Object> parameter){
		String sql = new SQL(){{
			SELECT(" * ");
			FROM(" product ");
		}}.toString();
		return sql;
	}
}
