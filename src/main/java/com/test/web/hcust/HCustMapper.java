package com.test.web.hcust;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface HCustMapper {
	public void insertHCust(HCust hCust);

	public HCust selectByCidCpw(HCust hCust);

	public int lastCNum();

	public int existId(String cid);
	
	public int countHCusts();
	public List<HCust> selectAll();
	
	

}