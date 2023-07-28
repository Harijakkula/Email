
Java Email Sender with Attachments
This Java program demonstrates how to send an email with attachments using the CFMail library. It allows users to send emails with multiple attachments to specified recipients.

**Table of Contents**
Introduction

How to Use

Dependencies

Usage

Contributing

**Introduction**

This program is a Java application that uses the CFMail library to send emails with attachments. It provides a simple and convenient way to send emails with files attached to them.

**How to Use**

Clone the repository or copy the Java code into your preferred Java IDE.

Replace the email addresses in the main method with the sender and recipient email addresses.

Update the attachment file paths with the desired files you want to attach to the email.

Set the email sender's username and password to allow the application to send emails via the provided email account. Please note that using your real email credentials can be a security risk, so be cautious.

Run the Main class to send the email with attachments.

**Dependencies**

This program relies on the CFMail library for email sending functionality. Ensure you have the CFMail library added to your project's build path before running the application.

**Usage**

The Main class contains the main method, which initializes the CFMailOptions object with email details, attachment files, and SMTP server settings. After setting up the options, the CFMail.sendEmail() method is called to send the email with attachments.

**Contributing**

Contributions to this project are welcome! If you encounter any bugs or want to enhance the functionality, feel free to submit issues or pull requests.
