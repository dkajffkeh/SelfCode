package mvc.controller;

import java.util.ArrayList;
import java.util.List;

import mvc.model.vo.AniBook;
import mvc.model.vo.Book;
import mvc.model.vo.CookBook;
import mvc.model.vo.Member;

public class LibraryManager implements LM_interface {
	
	private List<Book> list = new ArrayList<>();
	private List<Book> outList = new ArrayList<>();
	
	
	private Member mem =null;
	{
		  list.add(new CookBook("백종원의 집밥", "백종원", "tvN", true));   
		  list.add(new AniBook("한번 더해요", "미티", "원모어", 19));   
		  list.add(new AniBook("루피의 원피스", "루피", "japan", 12));   
		  list.add(new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false));   
		  list.add(new CookBook("최현석 날 따라해봐", "최현석", "소금책", true));  
	}
	@Override
	public void insertMember(Member mem) {
		
		this.mem=mem;
	}
	@Override
	public Member myinfo() {
		
		return mem;
		
	}
	@Override
	public List<Book> selectAll() {
	
		return list;
	}

	@Override
	public List<Book> searchBook(String keyWords) {
    
		List<Book>list2 = new ArrayList<>();
		
    for(int i = 0; i<list.size(); i++) {
    	//list 로 변수선언한 getTitle 에 접근하여 keyWords 가 존재 하는지 찾음.
			if(list.get(i).getTitle().contentEquals(keyWords)) {
				list2.add(list.get(i));
			}
		}
		
		
		return list2;
	}

	@Override
	public int rentBook(int bookNum) {
		
		int cCount = mem.getCouponCount();
		
			if(list.get(bookNum) instanceof CookBook) {
				outList.add(list.get(bookNum));
				list.remove(bookNum);
				cCount++;
				mem.setCouponCount(cCount);
				return 2;
							
			} else if(list.get(bookNum) instanceof AniBook){
				//Book type 
				if(mem.getAge()<((AniBook)list.get(bookNum)).getAccessAge()) {
					//빌린 책 넘버 
					
					return 1;
				} else {
					outList.add(list.get(bookNum));
					list.remove(bookNum);
				
					return 0;
					
					
				}
			}
				
		
		
		
		return 0;
	}

}
