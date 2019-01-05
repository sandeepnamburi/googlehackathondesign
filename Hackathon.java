import static java.lang.System.*;
import java.lang.*;
import java.nio.charset.Charset;
import java.util.*;

public class Hackathon extends User {

    public static void main(String args[]) throws Exception {

        Scanner scan = new Scanner(in);
        User user = new User();
        Team team = new Team();
        HashMap<String, User> map = new HashMap<String, User>();
        HashMap<String, Team> teamMap = new HashMap<String, Team>();

        String userName;
        String teamID;

        do {

            out.println("\nGoogle Hackathon Registration");
            out.println("1. User Registration");
            out.println("2. Team Registration");
            out.println("3. Submit Project");
            out.println("4. Delete Team/Hackathon");

            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    out.print("Enter username: ");
                    scan.nextLine();
                    userName = scan.nextLine();

                    if (map.containsKey(userName))  {
                        out.println("You're already registered.");
                    }

                    else {
                        user.addUser();
                        map.put(userName, user.getUser());
                        out.println("We have registered you as a user. ");
                    }

                    break;

                case 2:

                    out.print("Enter user name: ");
                    scan.nextLine();
                    userName = scan.nextLine();

                    out.print("Enter teamID: ");
                    teamID = scan.nextLine();

                    if (teamMap.containsKey(teamID))    {
                        team.addUserToTeam(map.get(userName));
                    }

                    else {
                        out.print("\nThe teamID does not exist. Enter teamID for a new team: ");
                        teamID = scan.nextLine();
                        team.addTeam();
                        teamMap.put(teamID, team.getTeam());
                        out.println("Successfully created a new team under the teamID: " + teamID);
                    }

                    break;

                case 3:

                    out.print("Enter teamID: ");
                    scan.nextLine();
                    teamID = scan.nextLine();

                    if (teamMap.containsKey(teamID))    {

                        out.print("Did you use a new language? (Y/N): ");
                        String newLanguage = scan.nextLine();

                            if (newLanguage.equalsIgnoreCase("y"))  {
                                teamMap.get(teamID).addLanguage();
                            }

                        teamMap.get(teamID).addSubmission();
                    }

                    else {
                        out.println("You have entered an invalid teamID.");
                    }

                    break;

                case 4:
                    out.println("Would you like to deregister from the team or hackathon? (T/H)");
                    scan.nextLine();
                    String deregister = scan.nextLine();

                    out.print("Enter username: ");
                    userName = scan.nextLine();


                    if (deregister.equalsIgnoreCase("h"))   {
                        map.get(userName).deleteUser();
                        map.remove(userName);

                        out.print("\nDo you have a team? (Y/N): ");
                        deregister = scan.nextLine();

                        if (deregister.equalsIgnoreCase("y"))   {
                            out.print("Enter teamID: ");
                            teamID = scan.nextLine();
                            teamMap.get(teamID).removeUserFromTeam(map.get(userName));
                            out.println("You have deregistered " + teamID + " from your team and removed " + userName + " as a user from the database.");
                        }


                    }

                    else if (deregister.equalsIgnoreCase("t"))  {
                        out.print("Enter teamID: ");
                        teamID = scan.nextLine();

                        teamMap.get(teamID).removeUserFromTeam(map.get(userName));
                        out.println("You have deregistered " + teamID + " from your team.");
                    }

                    break;

                default:
                    out.println("Please enter a valid number between 1-4.");
                    exit(0);
            }

        } while (true);
    }


}
