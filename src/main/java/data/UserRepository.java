package data;

public class UserRepository {

    private static volatile UserRepository instance = null;
    String email=RandomString.generate(10)+"@gmail.com";

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }



    public IUser newUser() {
        return User.get()
                .setSocialTitle(SocialTitle.MR)
                .setFirstName("someone")
                .setLastName("someoneelse")
                .setEMail(email)
                .setPassword("password1")
                .setBirthdate("1986-12-10")
                .setRecieveOffers(false)
                .setNewsLetter(true)
                .build();
    }

    //метод який рандомно генерує 10 символів до @

    public IUser addingAddressUser() {
        return User.get()
                .setSocialTitle(SocialTitle.MR)
                .setFirstName("Vasia")
                .setLastName("Pupkin")
                .setEMail("local_part@domain.com")
                .setPassword("qwerty")
                .setBirthdate("1995-25-05")
                .build();
    }

    public IUser updatingAddressUser() {
        return User.get()
                .setSocialTitle(SocialTitle.MRS)
                .setFirstName("Eva")
                .setLastName("Pupkina")
                .setEMail("local@mail.com")
                .setPassword("qwerty")
                .setBirthdate("1995-05-05")
                .build();
    }


    public IUser removingAddressUser() {
        return User.get()
                .setSocialTitle(SocialTitle.MR)
                .setFirstName("Bob")
                .setLastName("Marley")
                .setEMail("local_local@set.com")
                .setPassword("qwerty")
                .setBirthdate("2010-10-10")
                .build();
    }

    public IUser creatingUser() {
        return User.get()
                .setSocialTitle(SocialTitle.MR)
                .setFirstName("Vasilii")
                .setLastName("Pupkin")
                .setEMail("create@set.com")
                .setPassword("qwerty")
                .setBirthdate("2010-10-10")
                .build();
    }

}
