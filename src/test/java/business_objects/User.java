package business_objects;

public class User {
    private String login;
    private String password;
    private String messageTitle;
    private String messageBody;

    /**
     *This class provides login credentials and mail subject and title for test classes.
     * @param login login address for gmail.com
     * @param password password for gmail.com
     * @param messageTitle email title
     * @param messageBody email body
     */
    public User(String login, String password, String messageTitle, String messageBody) {
        this.login = login;
        this.password = password;
        this.messageTitle = messageTitle;
        this.messageBody = messageBody;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }
}
