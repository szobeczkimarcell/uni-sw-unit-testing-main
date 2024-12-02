package uni.sw.unit.testing.user;

public class UserDatabase {
    private UserListener userListener;
    private User user;

    public void addListener(UserListener userListener) {
        this.userListener = userListener;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
