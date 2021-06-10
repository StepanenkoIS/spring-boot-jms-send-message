package is.springbootjmssendmessage.model;

import java.io.Serializable;

public class Message implements Serializable {

    private String message;
    private Integer age;

    public String getMessage() {
        return message;
    }

    public Message() {
    }

    public Message(String message, Integer age) {
        this.message = message;
        this.age = age;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", age=" + age +
                '}';
    }
}
