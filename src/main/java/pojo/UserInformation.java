package pojo;

/**
 * #Author :Sino
 * #Date   :2021/11/13 11:12
 * #Describe:
 */
public class UserInformation {
    private String name;
    private String password;
    private String birthday;
    private String email;
    private ValidationQuestion question;
    private String answer;

    public UserInformation() {
    }

    public UserInformation(String name, String password, String birthday, String email,
                           ValidationQuestion question, String answer) {
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", question=" + question +
                ", answer='" + answer + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ValidationQuestion getQuestion() {
        return question;
    }

    public void setQuestion(ValidationQuestion question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
