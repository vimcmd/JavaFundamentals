package p02_classesAndLibrariesUsage.ch13_networking.sub05_chapterTasks.messenger.message;

public class MessageImpl implements Message {
    private String from;
    private String recipient;
    private String body;

    public MessageImpl(String from, String recipient, String body) {
        this.from = from;
        this.recipient = recipient;
        this.body = body;
    }

    public MessageImpl() {
    }

    @Override
    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getRecipient() {
        return recipient;
    }

    @Override
    public String getBody() {
        return body;
    }


}
