package com.salesforce.account;

import java.util.List;

public interface AccountDAO {
	public AccountVO getBalance();
	public List<AccountVO> getListAll();
	public List<AccountVO> getList(String searchStartDate, String searchEndDate);
	public List<AccountVO> getList(String tradingDate);
	public int insertTradeInfo(String type, int amount);
}
