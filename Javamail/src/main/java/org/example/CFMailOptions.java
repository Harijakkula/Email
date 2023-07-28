package org.example;
import java.io.File;
import java.util.List;

public class CFMailOptions {
    private String to;
    private String from;
    private String subject;
    private String username;
    private String password;
    private String cc ;
    private String bcc ;
    private List<File> attachmentFiles;
     private  String host ;
    private  int port ;
     private  int timeout ;
    private boolean debug ;
    private boolean useSSL ;
    private boolean useTLS ;
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getcc() {
        return cc;
    }

    public void setcc(String cc) {
        this.cc = cc;
    }

    public String getbcc() {
        return bcc;
    }

    public void setbcc(String bcc) {
        this.bcc = bcc;
    }

    public List<File> getAttachmentFiles() {
        return attachmentFiles;
    }

    public void setAttachmentFiles(List<File> attachmentFiles) {
        this.attachmentFiles = attachmentFiles;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String gethost() {
        return host;
    }

    public void sethost(String host) {
        this.host = host;
    }

    public int getport() {
        return port;
    }

    public void setport(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public boolean isUseTLS() {
        return useTLS;
    }

    public void setUseTLS(boolean useTLS) {
        this.useTLS = useTLS;
    }
}

