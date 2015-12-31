package hello;

import org.osgi.framework.*;

public class Activator implements BundleActivator {

	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
        System.out.println("Hello");
	}

	public void stop(BundleContext context) throws Exception {
        System.out.println("Stop");
	}

}
