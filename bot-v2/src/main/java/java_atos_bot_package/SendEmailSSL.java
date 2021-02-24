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
    String username = "email@mail.com";
    String password = "password";
    Properties prop = new Properties();
    
    props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "outlook.office365.com");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
   
    Session session = Session.getInstance(prop, 
        new Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("botAtosDoDia@gmail.com", "Celg2021");
          }
        });
    try {
      MimeMessage mimeMessage = new MimeMessage(session);
      mimeMessage.setFrom((Address) new InternetAddress("email@email.com"));
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
