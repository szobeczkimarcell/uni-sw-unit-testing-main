package uni.sw.unit.testing.user;

public class User {

    private String userName, password;
    private int id;

    private double academicAverage;

    public boolean isLoggedIn() {
         throw new UnsupportedOperationException("Currently not implemented function");
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public double getAcademicAverage(int semester) {
        return academicAverage;
    }

    public boolean update(String newPassword, boolean isLoggedIn) {
        this.password = newPassword;
        return isLoggedIn;
    }

}
