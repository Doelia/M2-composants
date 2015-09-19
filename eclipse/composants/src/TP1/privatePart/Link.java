package TP1.privatePart;

/**
 *  
 * @author doelia
 *
 */

public class Link extends StorageElement {
	
	private String contenu;

	public Link(String nom) {
		super(nom, 0);
		this.contenu = "";
	}

	public Link(String nom, String contenu) {
		super(nom, 0);
		this.contenu = contenu;
	}

	public int getSize() {
		return contenu.length();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visiteLink(this);
	}

	
}
