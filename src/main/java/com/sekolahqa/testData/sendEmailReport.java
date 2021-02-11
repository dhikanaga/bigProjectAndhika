package com.sekolahqa.testData;

import org.apache.commons.mail.*;
import org.testng.annotations.AfterClass;


public class sendEmailReport {
    private sendEmailReport sendEmail;

    public static void sendAttachedEmail(String path, String desc, String name, String testName) throws EmailException {
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath(path);
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(desc);
        attachment.setName(name);
        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("andhikabigproject@gmail.com", "dhikadhika123"));
        email.setSSLOnConnect(true);
        email.setFrom("andhikabigproject@gmail.com");
        email.setSubject("Test Result");
        email.setMsg("This is a test result for "+ testName);
        email.addTo("andhikasamosir4641@gmail.com");
        // add the attachment
        email.attach(attachment);
        // send the email
        email.send();
    }
}
