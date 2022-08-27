package git.cgteate.apptest2.ws.springtest2.ui.resource;

public class UserRequest {
    
    private String name;

    private String description;

    public UserRequest() {
    }

    public UserRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
