package com.epam.rd.contactbook;

public class Contact {
    private String contactName;

    public Contact(String contactName) {
        this.contactName = contactName;
        //Implement this method
    }

    public void rename(String newName) {
        this.contactName = newName;
        //Implement this method
    }

    private class NameContactInfo implements ContactInfo {
        public String getTitle() {
            return "Name";
        }

        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {
        String email;
        public String getTitle() {
            return "Email";
        }

        public String getValue() {
            return email;
        }
    }

    public static class Social implements ContactInfo {
        String title;
        String id;
        public String getTitle() {
            return title;
        }

        public String getValue() {
            return id;
        }
    }

    public Email addEmail(String localPart, String domain) {
        return null;
        //Implement this method
    }


    public Email addEpamEmail(String firstname, String lastname) {
        return null;
        //Implement this method
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        return null;
        //Implement this method
    }

    public Social addTwitter(String twitterId) {
        return null;
        //Implement this method
    }

    public Social addInstagram(String instagramId) {
        return null;
        //Implement this method
    }

    public Social addSocialMedia(String title, String id) {
        return null;
        //Implement this method
    }

    public ContactInfo[] getInfo() {
        ContactInfo[] getContactInfo = new ContactInfo[9];
        return getContactInfo;
        //Implement this method
    }

}
