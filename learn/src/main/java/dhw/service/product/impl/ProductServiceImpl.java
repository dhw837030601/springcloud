package dhw.service.product.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import dhw.bean.Product;
import dhw.bean.page.Pagination;
import dhw.bean.page.PaginationResult;
import dhw.bean.page.Sort;
import dhw.mapper.ProductMapper;
import dhw.service.product.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public PaginationResult<Product> getProductListByConditions(Pagination pagination) {
		// 设置分页参数
    	PageHelper.startPage(pagination.getPageNum(), pagination.getPageSize(),Sort.getSortString(pagination.getSort()));
    	// 查询符合条件的所有数据
		List<Product> list = productMapper.getProductListByConditions(pagination.getQuery());
		if(CollectionUtils.isEmpty(list)){
			logger.info("ProductServiceImpl->getProductListByConditions->商品列表为空！");
		}
		Page<Product> page = (Page<Product>) list;
		return new PaginationResult<Product>(pagination, (int) page.getTotal(), list);
	}

}
