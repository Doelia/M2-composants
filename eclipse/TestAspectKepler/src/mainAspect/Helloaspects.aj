package mainAspect;

public aspect Helloaspects {

	pointcut all():
		call(* Helloer.*(..));
	
	void around() : all() {
		System.out.println("---");
		proceed();
		System.out.println("---");
	}
}
