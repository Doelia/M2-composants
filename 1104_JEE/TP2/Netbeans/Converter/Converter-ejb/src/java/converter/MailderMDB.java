/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author doelia
 */
@JMSDestinationDefinition(name = "jms/MailContentQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "MailContentQueue")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MailContentQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})

public class MailderMDB implements MessageListener {

    @EJB
    Converter converter;

    public MailderMDB() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage mesg = (TextMessage) message;
                String content = mesg.getText();
                // Récupérer le montant à convertir :
                String s = content.substring(0, content.indexOf("#"));
                double amount = Double.parseDouble(s);
                Map<Monnaie, Double> map = converter.euroToOtherCurrencies(amount);
                Properties p = new Properties();
                p.put("mail.smtp.host", "smtp.gmail.com");
                p.put("mail.smtp.auth", "true");
                p.put("mail.smtp.starttls.enable", "true");
                javax.mail.Session session = javax.mail.Session.getInstance(p);
                javax.mail.Message msg = new MimeMessage(session);
                try {
                    // Préparation du mail
                    msg.setFrom(new InternetAddress("<compte-gmail>@gmail.com"));
                    String dest = content.substring(content.indexOf("#") + 1);
                    msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(dest));
                    String sujet = "Conversions de monnaie";
                    msg.setSubject(sujet);
                    // Mettre en forme les résultats retournés par le bean session (Map)
                    // dans une chaine de caractères contenant les balises HTML
                    // nécessaires pour construire un tableau HTML (variable content)
                    // Voir la capture d'écran ci-dessous (Figure 1)
                    msg.setContent(content, "text/html;charset=utf8");
                    msg.setSentDate(Calendar.getInstance().getTime());
                    // Préparation de l'envoi du mail
                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", 25, "<user>", "<mot-de-passe>");
                    // Envoi du mail
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                    System.out.println("Email Sent to " + dest); // Juste pour déboguer
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
