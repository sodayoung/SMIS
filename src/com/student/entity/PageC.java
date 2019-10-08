package com.student.entity;
/** 
* @author:YK;
* @date:2019年10月8日 下午2:10:49;
* @Description:分页帮助类
*/

import java.util.List;

public class PageC {
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private List<Student> students;
	
	public PageC(int currentPage, int pageSize, int totalCount, int totalPage, List<Student> students) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.students = students;
	}
	
	public PageC() {
		
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.totalPage = this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:totalCount/this.pageSize+1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	/*
	 * public void setTotalPage(int totalPage) { this.totalPage = totalPage; }
	 */

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
