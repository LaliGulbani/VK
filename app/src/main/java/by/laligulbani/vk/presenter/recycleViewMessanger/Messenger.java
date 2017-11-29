package by.laligulbani.vk.presenter.recycleViewMessanger;


public class Messenger {
    private String message;
    private String personSend;


    public Messenger(String message, String personSend) {
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

