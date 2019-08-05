/**
 * 
 */
package com.david.mail.emailManager;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Class for send emails
 * 
 * @author David Parra
 *
 */
public class EmailManager {

	private static final String CONTENT_TYPE_EMAIL = "text/html";

	private static EmailManager instance;

	private Session session;
	private Properties properties;
	private EmailProperties emailProperties;

	private EmailManager() {

	}

	/**
	 * Setup the session for send emails
	 * 
	 * @param emailProperties
	 */
	private void setupSession(EmailProperties emailProperties) {
		this.emailProperties = emailProperties;
		builProperties();
		this.session = Session.getInstance(this.properties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(emailProperties.getEmailEmisor(),
						emailProperties.getContrasenaEmailEmisor());
			}
		});
	}

	private void builProperties() {
		this.properties = new Properties();
		this.properties.put("mail.smtp.host", this.emailProperties.getHost());
		this.properties.put("mail.smtp.socketFactory.port", this.emailProperties.getPort());
		this.properties.put("mail.smtp.auth", "true");
		this.properties.put("mail.smtp.port", this.emailProperties.getPort());
		this.properties.put("mail.smtp.starttls", "true");
	}

	/**
	 * Static method for setup the send emails
	 * 
	 * @param emailProperties
	 * @return
	 */
	public synchronized static EmailManager setup(EmailProperties emailProperties) {
		if (instance == null) {
			instance = new EmailManager();
			instance.setupSession(emailProperties);
		}
		return instance;
	}

	/**
	 * Send the email to the recipients
	 * 
	 * @param emailContent
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws EmailException
	 * @throws IOException
	 */
	public void sendEmail(EmailContent emailContent)
			throws AddressException, MessagingException, EmailException, IOException {
		Message message = new MimeMessage(this.session);
		message.setFrom(new InternetAddress(this.emailProperties.getEmailEmisor()));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getAddressList(emailContent.getTo())));
		Multipart multipart = new MimeMultipart();
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(emailContent.getContentHtml(), CONTENT_TYPE_EMAIL);
		multipart.addBodyPart(bodyPart);
		if (!emailContent.getFiles().isEmpty()) {
			for (File file : emailContent.getFiles()) {
				bodyPart = new MimeBodyPart();
				bodyPart.attachFile(file);
				multipart.addBodyPart(bodyPart);
			}
		}
		message.setContent(multipart);
		Transport.send(message);
	}

	private static String getAddressList(String... recipients) throws EmailException {
		StringBuilder builder = new StringBuilder();
		int length = recipients.length;
		if (length > 0 && !recipients[0].isEmpty()) {
			for (int i = 0; i < recipients.length; i++) {
				builder.append(recipients[i]);
				if (!((i + 1) == recipients.length)) {
					builder.append(",");
				}
			}
			return builder.toString();
		} else {
			throw new EmailException("There are no recipients");
		}

	}

}
