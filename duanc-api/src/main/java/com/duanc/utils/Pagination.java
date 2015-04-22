package com.duanc.utils;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author chao.duan
 * @date 2015-1-10 16:37:43
 * @version 1.0
 */
public class Pagination implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int begin = 0;
	private int end;
	private int length = Constant.DEFAULT_PAGE_LENGTH;
	private int current = 1;
	private int total;
	private List<?> dataList;
	private int count;
	
	public Pagination() {
	}

	public Pagination(int cunrrent) {
		setCurrent(cunrrent);
	}
	
	public Pagination(int begin, int current) {
		this.begin = begin;
		this.current = current;
	}
	
	public int getBegin() {
		return begin;
	}

	public void setBegin(int current) {
		this.begin = (current - 1) * length;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int current) {
		this.end = current * this.length - 1;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		/*this.length = length;*/
	}

	public int getCount() {
		return count;
	}

	public void setCount(int total) {
		if(total == 0) {
			this.count = 0;
		} else if(total < 10 && total > 0) {
			this.count = 1;
		} else {
			this.count = total / this.length ;
			if(this.count * this.length < total) {
				this.count ++ ;
			}
		}
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
		setBegin(current);
		setEnd(current);
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		setCount(total);
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}
}
