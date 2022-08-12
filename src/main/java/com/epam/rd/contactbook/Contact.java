package com.epam.rd.contactbook;

public class Contact {
    private String contactName;
    private final ContactInfo[] contactInfo = new ContactInfo[10];
    private int addedPhoneNumber;
    private int addedEmail = 2;
    private int addedSocial = 5;


    public Contact(String contactName) {
        this.contactName = contactName;
        contactInfo[0] = new NameContactInfo();
    }

    public void rename(String newName) {
        if (newName != null && !newName.isEmpty()) {
            this.contactName = newName;
        }
    }

    private class NameContactInfo implements ContactInfo {

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {
        private final String title;
        private final String value;

        public Email(String title, String value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }

    public static class Social implements ContactInfo {
        private final String title;
        private final String value;

        public Social(String title, String value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public String getValue() {
            return this.value;
        }
    }

    public Email addEmail(String localPart, String domain) {
        if (addedEmail < 5) {
            Email email = new Contact.Email("Email", localPart + "@" + domain);
            contactInfo[addedEmail++] = email;
            return email;
        } else {
            return null;
        }
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if (addedEmail < 5) {
            Email email = new Contact.Email("Epam Email", firstname + "_" + lastname + "@epam.com");
            contactInfo[addedEmail++] = email;
            return email;
        } else {
            return null;
        }
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (addedPhoneNumber < 1) {
            ContactInfo phoneNumber = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
            contactInfo[1] = phoneNumber;
            addedPhoneNumber++;
            return phoneNumber;
        } else {
            return null;
        }
    }

    public Social addTwitter(String twitterId) {
        if (addedSocial < 10) {
            Social twitter = new Contact.Social("Twitter", twitterId);
            contactInfo[addedSocial++] = twitter;
            return twitter;
        } else {
            return null;
        }
    }

    public Social addInstagram(String instagramId) {
        if (addedSocial < 10) {
            Social instagram = new Contact.Social("Instagram", instagramId);
            contactInfo[addedSocial++] = instagram;
            return instagram;
        } else {
            return null;
        }
    }

    public Social addSocialMedia(String title, String id) {
        if (addedSocial < 10) {
            Social socialMedia = new Contact.Social(title, id);
            contactInfo[addedSocial++] = socialMedia;
            return new Social(title, id);
        } else {
            return null;
        }
    }

    public ContactInfo[] getInfo() {
        int copyArrayLength = 0;
        for (ContactInfo el : contactInfo) {
            if (el != null) {
                copyArrayLength++;
            }
        }
        ContactInfo[] copyContactInfo = new ContactInfo[copyArrayLength];
        int i = 0;
        for (ContactInfo el : contactInfo) {
            if (el != null) {
                copyContactInfo[i] = el;
                i++;
            }
        }
        return copyContactInfo;
    }

    public static void main(String[] args) {
        Contact contact = new Contact("William the Conqueror");

        Contact.Email email1 = contact.addEpamEmail("william", "legitimate");
        Contact.Email email2 = contact.addEmail("william", "normandy.fr");
        //System.out.println(Equals(Contact.Email.class, email1.getClass()));
        System.out.println(email1 instanceof Contact.Email);
        System.out.println(email1.getClass());
        System.out.println(Contact.Email.class);
    }
}
