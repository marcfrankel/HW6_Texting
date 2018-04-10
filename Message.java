import java.util.Optional;
import java.time.LocalDateTime;


/**
 * A simple texting class
 * @author mfrankel8
 * @version 1.0
 * 4/10/18
**/

public class Message {
    private Optional<String> contactName;
    private String to;
    private String from;
    private String body;
    private LocalDateTime date;
    private boolean isImportant;


    public Message (Optional<String> contactName, String to, String from,
        String body, LocalDateTime date, boolean isImportant) {

        this.contactName = contactName;
        this.to = to;
        this.from = from;
        this.body = body;
        this.date = date;
        this.isImportant = isImportant;
    }

    public Optional<String> getContactName() {
        return contactName;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean getIsImportant() {
        return isImportant;
    }
}
