package com.home.Taleswieazer.run;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.home.Taleswieazer.player.Player;

public class Run  {

	
	public static void main(String[] args) {						
		
		List<Player> players = new ArrayList<>();
		
		players.add(new Player("Alice", 899));
		players.add(new Player("Bob", 982));
		players.add(new Player("Chloe", 1090));
		players.add(new Player("Dale", 982));
		players.add(new Player("Eric", 1018));
	
	Collections.sort(players);
	 System.out.println(players);
	}
}
