package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class EmailSender {

    private static final String SENDER_EMAIL = "your_email@gmail.com";
    private static final String SENDER_PASSWORD = "your_password";

    public static void main(String[] args) {
        // Path to the Excel file containing recruiter data
        String excelFilePath = "/Users/osamashaikh/IdeaProjects/EMailsenderr/src/main/resources/recruiters.xlsx"; // Update this path to your actual file

        // List to hold recruiter data
        List<Map<String, String>> recruiters = new ArrayList<>();

        // Read the recruiters from the Excel file
        try {
            recruiters = readRecruitersFromExcel(excelFilePath);
        } catch (IOException e) {
            System.out.println("Error reading the Excel file: " + e.getMessage());
            return;
        }

        String subject = "Referral Request for Software Developer Roles";

        String bodyTemplate = "Hi {name},\n\n" +
                "I hope you're doing well. My name is Osama Shaikh, and I’m a Software Engineer at LTIMindtree, India.\n" +
                "I wanted to reach out to request your referral for Software Developer roles at your organization.\n\n" +
                "Here’s a quick overview of my profile:\n\n" +
                "Graduated with a Bachelor's in Computer Engineering (CGPA: 9.87, Distinction) from Thakur College of\n" +
                "Engineering & Technology.\n\n" +
                "Skilled in HTML, CSS, JavaScript, TypeScript, Angular, Java, Spring Boot, and the MERN stack,\n" +
                "with experience building scalable applications.\n\n" +
                "Solved 200+ Data Structures and Algorithms problems on platforms like LeetCode and GeeksforGeeks,\n" +
                "reflecting strong problem-solving skills.\n\n" +
                "Passionate about contributing to impactful projects and growing within a dynamic global organization.\n\n" +
                "I’d greatly appreciate it if you could consider referring me for any relevant roles.\n" +
                "Here’s my resume for your reference: https://tinyurl.com/28a8vfuj\n\n" +
                "Thank you for your time and support! I look forward to connecting with you.\n\n" +
                "Best regards,\n" +
                "Osama Shaikh\n";

        // Send emails to each recruiter
        for (Map<String, String> recruiter : recruiters) {
            String recipientName = recruiter.get("name");
            String recipientEmail = recruiter.get("email");

            // Print recruiter info for debugging
            System.out.println("Processing recruiter: {name=" + recipientName + ", email=" + recipientEmail + "}");

            // Skip if email is null or empty
            if (recipientEmail == null || recipientEmail.isEmpty()) {
                System.out.println("Skipping recruiter " + recipientName + " because the email is null or empty.");
                continue;
            }

            // Prepare email body with name inserted
            String body = bodyTemplate.replace("{name}", recipientName);

            // Send email
            sendEmail(recipientEmail, subject, body);

            // Wait for 30 to 60 seconds before sending the next email
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(31) + 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Map<String, String>> readRecruitersFromExcel(String filePath) throws IOException {
        List<Map<String, String>> recruiters = new ArrayList<>();

        // Open the Excel file
        try (FileInputStream file = new FileInputStream(new File(filePath));
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {

            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate over each row (skip the first row as it contains headers)
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {  // Skip header row
                    continue;
                }

                // Get name and email from the row
                String name = row.getCell(0) != null ? row.getCell(0).getStringCellValue() : null;
                String email = row.getCell(1) != null ? row.getCell(1).getStringCellValue() : null;

                // Add the recruiter to the list
                if (name != null && email != null) {
                    Map<String, String> recruiter = new HashMap<>();
                    recruiter.put("name", name);
                    recruiter.put("email", email);
                    recruiters.add(recruiter);
                }
            }
        }
        return recruiters;
    }

    private static void sendEmail(String toEmail, String subject, String body) {
        if (toEmail == null || toEmail.isEmpty()) {
            System.out.println("Email address is null or empty. Skipping...");
            return; // Skip this email
        }

        // Set email properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Create session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD);
            }
        });

        try {
            // Create and send email
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);

            // Log success
            System.out.println("Email sent to " + toEmail);
        } catch (MessagingException e) {
            // Log failure
            System.out.println("Failed to send email to " + toEmail + ": " + e.getMessage());
        }
    }
}
