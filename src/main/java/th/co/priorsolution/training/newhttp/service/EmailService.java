package th.co.priorsolution.training.newhttp.service;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.util.ByteArrayDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.co.priorsolution.training.newhttp.model.EmailRequestModel;
import th.co.priorsolution.training.newhttp.model.ResponseModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

@Service
@Slf4j
public class EmailService {


    public ResponseModel<Void> sendEmailWithAttechment(EmailRequestModel emailRequestModel) {
        ResponseModel<Void> result = new ResponseModel<>();

        result.setStatus(201);
        result.setDescription("ok");
        try {
            String to = "pongpat.phokeed@priorsolution.co.th";
            String from = "sender@example.com";
            String host = "localhost";
            int port = 2525;
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.port", String.valueOf(port));

            Session session = Session.getDefaultInstance(properties);


            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Test email with attachment2");

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("This is message body2");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();

            String filename = emailRequestModel.getFile().getOriginalFilename();
            DataSource source = new ByteArrayDataSource(emailRequestModel.getFile().getBytes(), "application/pdf");
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            // Send message
            Transport.send(message);
            log.info("Sent message successfully....");


        } catch (Exception e){
            e.printStackTrace();
            result.setStatus(500);
            result.setDescription(e.getMessage());
        }
        return result;
    }
}
