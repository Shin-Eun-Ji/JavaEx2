package com.saleforce.javadao;

import java.util.ArrayList;
import java.util.List;

public class AuthorApp {

    public static void main(String[] args) {
        int count = 0;
        AuthorDao dao = new AuthorDaoImpl();
        List<AuthorVO> list = new ArrayList<AuthorVO>();
        
//        insert
        AuthorVO vo = new AuthorVO(1, "백난도", "저자");
        count = dao.insert(vo);
        System.out.println("AuthorApp.dao.insert(vo) 결과 ---> " + count);
        
//        update
//        AuthorVO vo2 = new AuthorVO(13, "전두광", "모티브: 전두환");
//        dao.update(vo2);
        
//        delete
//        AuthorVO vo3 = new AuthorVO(12, "", "");
//        dao.delete(12);
//        Integer author_id = new Integer(12);
//        count = dao.delete(author_id);
//        System.out.print("삭제 데이터 건수: " + count);
        
        
//        select
//        AuthorVO vo3 = new AuthorVO();
//        dao.getList();
//        for(AuthorVO vo3 : list) {
//        	System.out.println(vo3);
//        }
//        System.out.print("전체 데이터 건수 : " + list.size());
    }

}
