package java_atos_bot_package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailSSL {
  public void sendEmail(String msg, String msgSub) {
    Date dataAtual = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    String dataFormatada = dateFormat.format(dataAtual);
    String username = "botAtosDoDia@gmail.com";
    String password = "Celg2021";
    Properties prop = new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "465");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.socketFactory.port", "465");
    prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    Session session = Session.getInstance(prop, 
        new Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("botAtosDoDia@gmail.com", "Celg2021");
          }
        });
    try {
      MimeMessage mimeMessage = new MimeMessage(session);
      mimeMessage.setFrom((Address)new InternetAddress("from@gmail.com"));
      mimeMessage.setRecipients(
          Message.RecipientType.TO, 
          (Address[])InternetAddress.parse("botAtosDoDia@gmail.com"));
      mimeMessage.setSubject("Novo Ato Dispon" + msgSub);
      mimeMessage.setText("Aviso de Recebimento de Ato Regulat" + dataFormatada + "\n" + msg);
      Transport.send((Message)mimeMessage);
      System.out.println("E-mail enviado com sucesso.");
    } catch (MessagingException e) {
      e.printStackTrace();
    } 
  }
}