package com.example.plugin;

public class JiaguEntity {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePass() {
        return keyStorePass;
    }

    public void setKeyStorePass(String keyStorePass) {
        this.keyStorePass = keyStorePass;
    }

    public String getKeyStoreKeyAlias() {
        return keyStoreKeyAlias;
    }

    public void setKeyStoreKeyAlias(String keyStoreKeyAlias) {
        this.keyStoreKeyAlias = keyStoreKeyAlias;
    }

    public String getKeyStoreKeyAliasPwd() {
        return keyStoreKeyAliasPwd;
    }

    public void setKeyStoreKeyAliasPwd(String keyStoreKeyAliasPwd) {
        this.keyStoreKeyAliasPwd = keyStoreKeyAliasPwd;
    }

    public String getJiaguToolPath() {
        return jiaguToolPath;
    }

    public void setJiaguToolPath(String jiaguToolPath) {
        this.jiaguToolPath = jiaguToolPath;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    private String password;
    private String keyStorePath;
    private String keyStorePass;
    private String keyStoreKeyAlias;
    private String keyStoreKeyAliasPwd;
    private String jiaguToolPath;
    private String outputFile;

    @Override
    public String toString() {
        return "JiaguEntity{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", keyStorePath='" + keyStorePath + '\'' +
                ", keyStorePass='" + keyStorePass + '\'' +
                ", keyStoreKeyAlias='" + keyStoreKeyAlias + '\'' +
                ", keyStoreKeyAliasPwd='" + keyStoreKeyAliasPwd + '\'' +
                ", jiaguToolPath='" + jiaguToolPath + '\'' +
                ", outputFile='" + outputFile + '\'' +
                '}';
    }
}
