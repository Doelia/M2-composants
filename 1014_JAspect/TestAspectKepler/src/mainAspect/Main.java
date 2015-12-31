package mainAspect;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		Helloer h = new Helloer();
		
		Personne pierre = new Personne("pierre");
		Personne paul = new Personne("paul");
		Personne jean = new Personne("jean");
		
		Place ecole = new Place("ecole");
		ecole.add(pierre);
		ecole.add(paul);
		
		Place theatre = new Place("theatre");
		theatre.add(paul);
		theatre.add(jean);
		
		h.helloTo(pierre);
		h.helloTo(theatre);
	}

}
