package com.enuri.makeshop.admin.infra.mail;

public interface EmailService {

    void sendEmail(EmailMessage emailMessage);
}
