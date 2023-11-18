package com.server.webbansach_backend.service;

public interface EmailService {
    public void sendMessage(String from, String to, String subject, String text);
}
