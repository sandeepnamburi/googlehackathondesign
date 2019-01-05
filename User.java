import java.util.*;

public class User {

    String userName;
    boolean team = false;
    int submissions;
    private static final ArrayList<User> userList = new ArrayList<User>();


    public User()   {
        this.userName = userName;
        this.team = team;
        this.submissions = submissions;
    }

    public void addUser()   {
        userList.add(this);
    }

    public void deleteUser()    {
        userList.remove(this);
    }

    public User getUser() {
        int userCount = userList.size();
        if (userCount > 0) {
            return userList.remove(userCount-1);
        }
        return new User();
    }



}
