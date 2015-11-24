
import converter.Converter;
import javax.naming.*;

// export CLASSPATH=.:jndi.properties:/Applications/NetBeans/glassfish-4.1/glassfish/lib/appserv-rt.jar

class Client {
    public static void main(String[] args) {
        System.out.println("Hello :)");
        try {
            InitialContext context = new InitialContext();

            System.out.println("Lookup...");
            Converter converter = (Converter) context.lookup(
                "java:global/ConverterTP1/ConverterTP1-ejb/ConverterBean");

            double converted = converter.euroToOtherCurrency(10, "USD");
            System.out.println("Go :"+converted);
        } catch (Exception e) {
            System.out.println("Fail :"+e.getMessage());
        }
    }

}
