package TP1.objs;

import TP1.pattern.Visitor;


/**
 * Représente un fichier texte
 * @author doelia
 *
 */
public class File extends ElementStockage {

	private String content; // Contenu

	public File(String nom) {
		super(nom, 0);
		this.content = "";
	}

	public File(String nom, String contenu) {
		super(nom, 0);
		this.content = contenu;
	}

	@Override
	public int getSize() {
		return content.length();
	}

	public void cat() {
		System.out.println(content);
	}

	public void setContents(String c) {
		content = c;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
