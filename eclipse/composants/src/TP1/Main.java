package TP1;

import TP1.objs.Directory;
import TP1.objs.File;

public class Main {
	
	public static void main(String[] args) {
		test_1();
	}

	/**
	 * Contruit l'arbo suivante :
	 * 
	 * /Pastis/
	 *		Martini.txt
	 *		Ricard.txt
	 *		Eau/
	 *			Glacons.txt
	 */
	public static void test_1() {
		Directory d = new Directory("Pastis");
		Directory d2 = new Directory("Eau");
		
		File f = new File("Martini.txt", "martini");
		File f2 = new File("Ricard.txt", "ricard");
		File f3 = new File("Glacons.txt", "glaçons");
		File f4 = new File("Duval.txt", "duval");

		d.add(f); // Ajout du fichier Maritni dans Pastis
		d.add(f2); // Ajout du fichier ricard dans Pastis
		d.add(d2); // Ajout du dir Eau dans Pastis
		d2.add(f3); // Ajout de glaçons dans Eau

		System.out.println("taille " + d.name + " : " + d.getSize());
		System.out.println("taille " + d2.name + " : " + d2.getSize());
		System.out.println("taille " + f.name + " : " + f.getSize());
		System.out.println("taille " + f2.name + " : " + f2.getSize());
		System.out.println("taille " + f3.name + " : " + f3.getSize());
		System.out.println("taille " + f4.name + " : " + f4.getSize());

		System.out.println("ls Pastis :");
		d.ls();
		
		System.out.println("ls Eau :");
		d2.ls();
	}

}
