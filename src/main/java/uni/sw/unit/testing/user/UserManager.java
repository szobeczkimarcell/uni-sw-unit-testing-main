package uni.sw.unit.testing.user;

import java.util.Objects;

public class UserManager {
    private User user;
    private UserDatabase userDatabase;

    public UserManager(User user, UserDatabase userDatabase) {
        Objects.requireNonNull(user);
        Objects.requireNonNull(userDatabase);
        this.user = user;
        this.userDatabase = userDatabase;
    }

    public void initialize() {
        userDatabase.addListener(new UserListener());
        userDatabase.setUser(user);
    }



}
