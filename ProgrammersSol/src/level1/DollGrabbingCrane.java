package level1;

import java.util.ArrayList;
import java.util.List;

public class DollGrabbingCrane {

	public static void main(String[] args) {
		int [][] board = new int [][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int []   moves = new int [] {1,5,3,5,1,2,1,4};
    
		solution(board,moves);
	
	}  
	public static int solution(int[][] board, int[] moves) {
	        int answer = 0;    

	        List<Integer> list = new ArrayList<>();
      
	        for(int i = 0 ; i<moves.length; i++) {
	        	
	        	for(int j = 0; j<board.length ; j++) {
	        		        		
	        		int temp = board[j][moves[i]-1];	
	        	
	        		if(temp!=0) {
	        			
	        			if(list.size()>0) {
	        				
	        				if(list.get(list.size()-1)==temp) {
	        					
	        					list.remove(list.size()-1);
	        					answer+=2;
	        					
	        				} else {
	        					
	        					list.add(temp);
	        				}
	        			
	        				
	        			} else {
	        				list.add(temp);
	        			}
	        			
	        			board[j][moves[i]-1]=0;
	        			break;
	        			
	        		}
	        		
	        	}
	        	
	        }	        
	        
	         return answer;
	    }
	}