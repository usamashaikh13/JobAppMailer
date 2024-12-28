<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Job Mailer - README</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background: linear-gradient(to right, #4facfe, #00f2fe);
      color: #333;
    }
    header {
      text-align: center;
      padding: 3rem 1rem;
      background: linear-gradient(to right, #009ffd, #2a2a72);
      color: #fff;
      animation: fadeInDown 1s ease-in-out;
    }
    header h1 {
      font-size: 3rem;
      margin: 0;
    }
    header h2 {
      font-size: 1.5rem;
      margin-top: 1rem;
    }
    p {
      font-size: 1.2rem;
      line-height: 1.6;
      text-align: center;
      color: #fff;
    }
    .container {
      max-width: 900px;
      margin: 2rem auto;
      padding: 1.5rem;
      background: #fff;
      border-radius: 8px;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
      animation: slideIn 1.5s ease-out;
    }
    h2 {
      font-size: 1.8rem;
      margin-bottom: 1rem;
      color: #009ffd;
    }
    ul {
      list-style-type: disc;
      padding-left: 2rem;
    }
    li {
      font-size: 1.1rem;
      margin-bottom: 0.5rem;
    }
    code {
      display: block;
      background: #333;
      color: #00ff99;
      padding: 1rem;
      border-radius: 8px;
      margin: 1rem 0;
      font-size: 0.9rem;
      overflow-x: auto;
      white-space: pre-wrap;
    }
    .buttons {
      text-align: center;
      margin-top: 1.5rem;
    }
    .btn {
      display: inline-block;
      margin: 0.5rem;
      padding: 0.8rem 1.5rem;
      background: #009ffd;
      color: #fff;
      text-decoration: none;
      border-radius: 5px;
      font-size: 1rem;
      font-weight: bold;
      box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);
      transition: all 0.3s ease-in-out;
    }
    .btn:hover {
      background: #0066cc;
      transform: scale(1.1);
    }
    footer {
      text-align: center;
      padding: 1rem;
      background: #2a2a72;
      color: #fff;
      margin-top: 2rem;
    }
    @keyframes fadeInDown {
      from {
        opacity: 0;
        transform: translateY(-50px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    }
    @keyframes slideIn {
      from {
        opacity: 0;
        transform: translateX(-100%);
      }
      to {
        opacity: 1;
        transform: translateX(0);
      }
    }
  </style>
</head>
<body>
<header>
  <h1>Job Mailer</h1>
  <h2>Automated Job Application Emailer</h2>
  <p>Send job application emails with dynamic content and delays using Java and JavaMail API.</p>
</header>
<div class="container">
  <h2>Features</h2>
  <ul>
    <li>Send personalized emails to recruiters with a single script.</li>
    <li>Dynamic delays between emails (30-60 seconds).</li>
    <li>Secure environment variable configuration for sensitive credentials.</li>
    <li>Detailed email templates with placeholders for names.</li>
  </ul>
  <h2>Setup</h2>
  <ol>
    <li>Clone this repository to your local machine.</li>
    <li>Download the <strong>JavaMail API (javax.mail-1.6.2.jar)</strong> library.</li>
    <li>Set up the following environment variables:
      <ul>
        <li><strong>SENDER_EMAIL:</strong> Your email address.</li>
        <li><strong>SENDER_PASSWORD:</strong> Your email password.</li>
      </ul>
    </li>
    <li>Compile and run the program.</li>
  </ol>
  <h2>Code Example</h2>
  <code>
import javax.mail.*;<br>
import javax.mail.internet.*;<br>
Properties props = new Properties();<br>
props.put("mail.smtp.host", "smtp.gmail.com");<br>
props.put("mail.smtp.auth", "true");<br>
// Set credentials securely<br>
Session session = Session.getInstance(props, ...);
  </code>
  <div class="buttons">
    <a href="https://github.com/your-repo" class="btn">View on GitHub</a>
    <a href="mailto:osamashaikh@example.com" class="btn">Contact Developer</a>
  </div>
</div>
<footer>
  <p>© 2024 Job Mailer | Built with ❤ by Osama Shaikh</p>
</footer>
</body>
</html>
