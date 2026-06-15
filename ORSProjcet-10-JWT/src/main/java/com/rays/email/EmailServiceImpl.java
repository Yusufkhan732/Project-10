package com.rays.email;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * EmailServiceImpl handles sending emails using Spring's JavaMailSender.
 * <p>
 * Supports both plain text and HTML messages.
 *
 * @author Yusuf Khan
 */
@Service
public class EmailServiceImpl implements EmailServiceInt {

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * Sends an email message.
	 *
	 * @param msg EmailMessage object containing recipient, subject and message
	 *            content.
	 */
	@Override
	public void sendMail(EmailMessage msg) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			helper.setTo(msg.getTo());
			helper.setSubject(msg.getSubject());

			if (msg.getMessageType() == EmailMessage.HTML_MSG) {
				helper.setText(msg.getMessage(), true); // HTML
			} else {
				helper.setText(msg.getMessage(), false); // TEXT
			}

			mailSender.send(mimeMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}