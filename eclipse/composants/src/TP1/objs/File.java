package TP1.objs;

import TP1.pattern.Visitor;

public class File extends ElementStockage {
// classe reprsentant un fichier

	private String contenu; // possde un contenu

	public File(String nom) {
		super(nom, 0);
		this.contenu = "";
	}

	public File(String nom, String contenu) {
		super(nom, 0);
		this.contenu = contenu;
	}

	@Override
	public int size() {
		return contenu.length();
	}

	public void cat() {
		System.out.println(contenu);
	}

	public void setContents(String c) {
		contenu = c;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
