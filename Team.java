import java.util.ArrayList;
import static java.lang.System.*;

public class Team extends User {

    private static final ArrayList<Team> teamList = new ArrayList<Team>();
    private static final ArrayList<User> userListInTeam = new ArrayList<User>();
    private int submissions;
    private int languages;


    public Team()   {
        this.submissions = submissions;
        this.languages = languages;
    }

    public void addTeam()   {
        teamList.add(this);
    }

    public void addLanguage() throws Exception   {
        if (this.languages > 2)   {
            out.println("You have exceeded the number of languages.");
            throw new Exception();
        }
        else {
            this.languages++;
        }
    }

    public void addSubmission() {
        if (this.submissions > 3)   {
            out.println("You have exceeded the number of submissions.");
        }
        else {
            out.println("You have successfully submitted your project.");
            this.submissions++;
        }
    }

    public void addUserToTeam(User user) {
        userListInTeam.add(user);
    }

    public void removeUserFromTeam(User user) {
        userListInTeam.remove(user);
    }

    public Team getTeam () {
        int teamCount = teamList.size();
        if (teamCount > 0) {
            return teamList.remove(teamCount-1);
        }
        return new Team();
    }


}
