package Week10.MessagingSystem;

@UserPermission(2)
public class Admin {
    private String username;
    public Admin(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
