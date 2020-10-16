package sk.itsovy.adnroid.topics;

public class Topic {
    private String topic;// pracujeme so stringom
    private String student;// pracujeme so stringom



    public Topic(String topic) {
        this.topic = topic;
        this.student = "n/a";
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
}
