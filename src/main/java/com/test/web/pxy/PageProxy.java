package com.test.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data @Lazy
@Component("pagePX")
public class PageProxy extends Proxy {
	@Autowired CrawlingProxy crawler;
	
	private int rowCount, startRow, endRow,
				pageCount, pageSize , startPage, endPage, currPage,
				blockCount, blockSize, nextBlock, prevBlock, currBlock;
	
	private boolean existPrev, existNext;
	private String search;
	
	public void paging() {
		pageCount = (rowCount%pageSize ==0 )? rowCount / pageSize :
			rowCount/ pageSize +1;
		blockCount = (pageCount%blockSize ==0)? pageCount/ blockSize:
			pageCount/blockSize+1;
		startRow = currPage * pageSize;
		endRow = (currPage != pageCount-1)?  startRow + (pageSize-1) : rowCount-1 ;
		currBlock = currPage / blockSize;
		startPage = currBlock * blockSize;
		endPage = (currBlock != blockCount-1)?  startPage + (blockSize-1) : pageCount-1 ;
		prevBlock = startPage - blockSize;
		nextBlock = startPage + blockSize;
		
		existPrev = currBlock != 0;
		existNext = currBlock != blockCount-1;
		
		
		
		
		
		
	}

}
