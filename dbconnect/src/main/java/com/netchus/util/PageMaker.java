package com.netchus.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.netchus.domain.Criteria;

public class PageMaker {
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int totalCount;
	private Criteria cri;
	
	@Autowired
	public PageMaker(Criteria cri) {
		super();
		this.cri = cri;
	}
	
	public int getPageNum() {
		return cri.getPageNum();
	}

	public int getAmount() {
		return cri.getAmount();
	}

	private void calc() {
        
        endPage = (int) (Math.ceil(cri.getPageNum() / (double) cri.getAmount()) * cri.getAmount());
 
        startPage = (endPage - cri.getPageNum()) + 1;
        if(startPage <= 0) startPage = 1;
        
        int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getAmount()));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }
        prev = startPage == 1 ? false : true;
        next = endPage * cri.getAmount() < totalCount ? true : false;
    }
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calc();
	}
	
	public boolean isPrev() {
        return prev;
    }
    public void setPrev(boolean prev) {
        this.prev = prev;
    }
    public boolean isNext() {
        return next;
    }
    public void setNext(boolean next) {
        this.next = next;
    }
	
}
