# Job Mailer

## Automated Job Application Emailer  
Send job application emails with dynamic content and delays using Java and JavaMail API.

---

### Features
- Send personalized emails to recruiters with a single script.
- Dynamic delays between emails (30-60 seconds).
- Secure environment variable configuration for sensitive credentials.
- Detailed email templates with placeholders for names.

---

### Setup
1. Clone this repository to your local machine.
2. Download the **JavaMail API (javax.mail-1.6.2.jar)** library.
3. Set up the following environment variables:
   - **SENDER_EMAIL:** Your email address.
   - **SENDER_PASSWORD:** Your email password.
4. Compile and run the program.

---

### Code Example

```java
import javax.mail.*;
import javax.mail.internet.*;
Properties props = new Properties();
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.auth", "true");
// Set credentials securely
Session session = Session.getInstance(props, ...);
