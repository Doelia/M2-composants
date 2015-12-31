package TP1.privatePart;

/**
 * Représente un fichier texte
 * @author doelia
 *
 */
public class File extends StorageElement {

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
		v.visiteFile(this);
	}

	public void remove() {
		// TODO Auto-generated method stub
	}

}
