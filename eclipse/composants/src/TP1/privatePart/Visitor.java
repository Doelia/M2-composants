package TP1.privatePart;

public interface Visitor {
	
	public abstract void visiteLink(Link o);
	public abstract void visiteFile(File o);
	public abstract void visiteSymLink(Symlink o);
	public abstract void visiteDirectory(Directory o);
	public abstract void visiteArchive(Archive o);
	
}
