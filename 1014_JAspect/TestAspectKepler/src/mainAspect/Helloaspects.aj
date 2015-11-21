package mainAspect;

public aspect Helloaspects {

	pointcut toPersonne(Personne p):
		args(p) &&
		call(* Helloer.*(Personne));
	
	pointcut toPlace():
		call (* Helloer.*(Place));
	
	before(Personne p): toPersonne(p) {
		System.out.println("Affichage individuel à "+p);
	}
	
}
