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
		  list.add(new CookBook("�������� ����", "������", "tvN", true));   
		  list.add(new AniBook("�ѹ� ���ؿ�", "��Ƽ", "�����", 19));   
		  list.add(new AniBook("������ ���ǽ�", "����", "japan", 12));   
		  list.add(new CookBook("�������� �󸶳� ���ְԿ�", "������", "����", false));   
		  list.add(new CookBook("������ �� �����غ�", "������", "�ұ�å", true));  
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
    	//list �� ���������� getTitle �� �����Ͽ� keyWords �� ���� �ϴ��� ã��.
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
					//���� å �ѹ� 
					
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
