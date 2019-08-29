package com.jw.domain;

public class UserRole {

    private String type;
    private double signingLimit;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSigningLimit() {
        return signingLimit;
    }

    public void setSigningLimit(double signingLimit) {
        this.signingLimit = signingLimit;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "type='" + type + '\'' +
                ", signingLimit=" + signingLimit +
                '}';
    }
}
