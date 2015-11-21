package mainAspect;

public class Helloer {

	public void helloTo(Personne p) {
		System.out.println("Hello to "+p);
	}
	
	public void helloTo(Place p) {
		System.out.println("Hello to "+p);
	}
}
