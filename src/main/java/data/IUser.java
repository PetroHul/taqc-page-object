package data;

public interface IUser {
    SocialTitle getSocialTitle();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getPassword();
    String getBirthdate();
    boolean isNewsletter();
    boolean isRecieveOffers();

}
