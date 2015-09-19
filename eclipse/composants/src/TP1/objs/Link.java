package TP1.objs;

import TP1.pattern.Visitor;

public class Link extends ElementStockage {
	
	private String contenu;

	public Link(String nom) {
		super(nom, 0);
		this.contenu = "";
	}

	public Link(String nom, String contenu) {
		super(nom, 0);
		this.contenu = contenu;
	}

	public int size() {
		return contenu.length();
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
}
