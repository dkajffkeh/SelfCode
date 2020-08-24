package mvc.controller;

import java.util.ArrayList;
import java.util.List;

import mvc.model.vo.Book;
import mvc.model.vo.Member;

public interface LM_interface {

   public void insertMember(Member mem);
   public Member myinfo();
   public List<Book> selectAll();
   public List<Book> searchBook(String keyWords);
   public int rentBook(int bookNum);
	
}
