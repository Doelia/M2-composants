package TP1.privatePart;

/**
 * @author doelia
 */

public class Symlink extends StorageElement {
	
	private StorageElement reference;

	public Symlink(String nom) {
		super(nom, 0);
		reference = null;
	}

	public Symlink(String nom, StorageElement e) {
		super(nom, 0);
		reference = e;
	}

	public int getSize() {
		return (reference == null) ? 0 : reference.getSize();
	}

	// affiche le symbole du lien puis l'adresse absoule de sa rfrence
	public void cat() {
		System.out.println("ln -s " + reference.getAbsoluteLocation() + " " + name);
	}

	@Override
	public void accept(Visitor v) {
	}

}
