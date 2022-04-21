package com.example.qamberhaider.mazdor_user;

/**
 * Created by qamber.haider on 5/23/2018.
 */

public class Listdata_Pro {

    public String prFirstName;
    public String PrDesignation;
    public String prEmail;
    public String prNic;
    public String prProfilepicture;
    public String prTelephone;
    public String prid;

    public Listdata_Pro() {
    }

    public Listdata_Pro(String prFirstName, String prDesignation, String prEmail, String prNic, String prProfilepicture, String prTelephone, String prid) {
        this.prFirstName = prFirstName;
        PrDesignation = prDesignation;
        this.prEmail = prEmail;
        this.prNic = prNic;
        this.prProfilepicture = prProfilepicture;
        this.prTelephone = prTelephone;
        this.prid = prid;
    }

    public String getPrFirstName() {
        return prFirstName;
    }

    public void setPrFirstName(String prFirstName) {
        this.prFirstName = prFirstName;
    }

    public String getPrDesignation() {
        return PrDesignation;
    }

    public void setPrDesignation(String prDesignation) {
        PrDesignation = prDesignation;
    }

    public String getPrEmail() {
        return prEmail;
    }

    public void setPrEmail(String prEmail) {
        this.prEmail = prEmail;
    }

    public String getPrNic() {
        return prNic;
    }

    public void setPrNic(String prNic) {
        this.prNic = prNic;
    }

    public String getPrProfilepicture() {
        return prProfilepicture;
    }

    public void setPrProfilepicture(String prProfilepicture) {
        this.prProfilepicture = prProfilepicture;
    }

    public String getPrTelephone() {
        return prTelephone;
    }

    public void setPrTelephone(String prTelephone) {
        this.prTelephone = prTelephone;
    }

    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }
}
