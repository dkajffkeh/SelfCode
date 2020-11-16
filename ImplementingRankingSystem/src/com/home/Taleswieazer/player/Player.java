package com.home.Taleswieazer.player;

import java.lang.Comparable;

public class Player implements Comparable<Player>
{

	private String userId;
	private int userPoint;
	
	public Player() {}
	
	public Player(String userId, int userPoint) {
		
		this.userId = userId;
		this.userPoint = userPoint;
	}



	public String getId() {
		
		return userId;
	}
    public int getPoint() {
		
		return userPoint;
	}
    @Override
	public String toString() {
		return "ID=" + userId + ", Score=" + userPoint;
	}


	@Override
	public int compareTo(Player anotherUserPoint) {
		
		return Integer.compare(userPoint, anotherUserPoint.userPoint);
	}
	
}
