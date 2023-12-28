package com.salesforce.account;

public class AccountApp {

	public static void main(String[] args) {
		int count = 0;
		AccountDAO dao = new AccountDAOImpl();
		// insert
//		AccountVO account = new AccountVO(1, 3000, 0, "2023-12-27", 0);
		count = dao.insertTradeInfo("Deposit", 1000);
		System.out.println("AccountApp.dao.insert(vo) 결과 ---> " + count);

		
	}

}
