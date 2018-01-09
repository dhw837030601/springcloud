package dhw.service.product;

import dhw.bean.Product;
import dhw.bean.page.Pagination;
import dhw.bean.page.PaginationResult;

public interface ProductService {

	public PaginationResult<Product> getProductListByConditions(Pagination pagination);
}
