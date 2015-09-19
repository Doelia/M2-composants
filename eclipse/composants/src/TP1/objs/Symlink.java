package TP1.objs;

import TP1.pattern.Visitor;

public class Symlink extends ElementStockage {
	
	private ElementStockage reference;

	public Symlink(String nom) {
		super(nom, 0);
		reference = null;
	}

	public Symlink(String nom, ElementStockage e) {
		super(nom, 0);
		reference = e;
	}

	public int getSize() {
		return (reference == null) ? 0 :  reference.getSize();
	}

	// affiche le symbole du lien puis l'adresse absoule de sa rfrence
	public void cat() {
		System.out.println("ln -s " + reference.getAbsoluteLocation() + " " + name);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}

}
