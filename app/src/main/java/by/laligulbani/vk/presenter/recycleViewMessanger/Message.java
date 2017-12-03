package by.laligulbani.vk.presenter.recycleViewMessanger;


public class Message {
    private String message;
    private String personSend;


    public Message(String message, String personSend) {
        this.message = message;
        this.personSend = personSend;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPersonSend() {
        return personSend;
    }

    public void setPersonSend(String personSend) {
        this.personSend = personSend;
    }
}

