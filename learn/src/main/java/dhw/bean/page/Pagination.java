package  dhw.bean.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int FIRST_PAGE_NUMBER = 1;

	public static final String DEFAULT_SORT_COLUMN = "id";

	private int pageNum;

	private int pageSize;

	private Map<String, Object> query;

	private Sort[] sort;

	public Pagination() {
		pageNum = 1;
		pageSize = 20;
		initSort();
	}

	public Pagination(int pageNum, int pageSize) {
		this.pageNum = validatePageNum(pageNum);
		this.pageSize = pageSize;
		initSort();
	}

	public Pagination(int pageNum, int pageSize, Map<String, Object> query) {
		this.pageNum = validatePageNum(pageNum);
		this.pageSize = pageSize;
		this.query = query;
		initSort();
	}

	public Pagination(int pageNum, int pageSize, Map<String, Object> query,
			Sort... sort) {
		this.pageNum = validatePageNum(pageNum);
		this.pageSize = pageSize;
		this.query = query;
		this.sort = sort;
	}

	private void initSort() {
		Sort s = new Sort(DEFAULT_SORT_COLUMN, Sort.DESC);
		sort = new Sort[1];
		sort[0] = s;
		if (query == null) {
			query = new HashMap<String, Object>(16);
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public Sort[] getSort() {
		return sort;
	}

	public void setSort(Sort... sort) {
		this.sort = sort;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getQuery() {
		return query;
	}

	public void setQuery(Map<String, Object> query) {
		this.query = query;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	private int validatePageNum(int pageNum) {
		if (pageNum < FIRST_PAGE_NUMBER) {
			return FIRST_PAGE_NUMBER;
		}
		return pageNum;
	}

	public int getStart() {
		return (this.getPageNum() - FIRST_PAGE_NUMBER) * this.getPageSize();
	}

}
