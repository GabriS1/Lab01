package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	LinkedList<String> parole = new LinkedList<String>();
	
		
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		//TODO
		parole.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(parole, new ComparatoreAlfabetico());
		
		return parole;
	}
	
	public void reset() {
		// TODO
		parole.removeAll(parole);
	}
	
	public List<String> cancella(String s) {
	
		if(!s.contains("\n")) {
			parole.remove(s);
		}else {
			String s0[]= s.split("\n");
			for(int i=0; i<s0.length; i++) {
				parole.remove(s0[i]);
			}
		}
		
		return parole; 
	}

}
