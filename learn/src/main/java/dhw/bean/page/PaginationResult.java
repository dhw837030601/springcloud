package  dhw.bean.page;

import java.io.Serializable;
import java.util.List;

public class PaginationResult<T extends Serializable> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int pageNum;
	
	private int pageSize;
	
	private int totalPage;
	
	private int totalNum;
	
	private List<T> result;
	
	public PaginationResult(){
		
	}
	
	public PaginationResult(int pageNum, int pageSize, int totalNum, List<T> result){
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.result = result;
		calculatePage();
	}
	
	public PaginationResult(Pagination pagination,int totalNum,List<T> result){
		this.pageNum = pagination.getPageNum();
		this.pageSize = pagination.getPageSize();
		this.totalNum = totalNum;
		this.result = result;
		calculatePage();
	}
	
	public boolean hasResult(){
		return result==null?false:true;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
		calculatePage();
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	private void calculatePage(){
		if( totalNum%pageSize == 0 ){
			this.totalPage = totalNum/pageSize;
		}else{
			this.totalPage = totalNum/pageSize+1;
		}
	}
}
