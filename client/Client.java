
import converter.Converter;
import javax.naming.*;

// export CLASSPATH=.:jndi.properties:/Applications/NetBeans/glassfish-4.1/glassfish/lib/appserv-rt.jar

class Client {
    public static void main(String[] args) {
        try {
            InitialContext context = new InitialContext();
            Converter converter = (Converter) context.lookup(
                "java:global/Converter/Converter-ejb/ConverterBean");

            double converted = converter.euroToOtherCurrency(10, "USD");
            System.out.println("Go :"+converted);
        } catch (Exception e) {
            System.out.println("Fail :"+e.getMessage());
        }
    }

}
