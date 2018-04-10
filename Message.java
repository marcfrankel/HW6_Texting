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

    /**
     * Public Message contructor
     * @param  contactName Optional contact name on the message
     * @param  to          Who the message is to
     * @param  from        Who the message is from
     * @param  body        Body of the message
     * @param  date        Date of the message
     * @param  isImportant if the message is important
     *
     */
    public Message(Optional<String> contactName, String to, String from,
        String body, LocalDateTime date, boolean isImportant) {

        this.contactName = contactName;
        this.to = to;
        this.from = from;
        this.body = body;
        this.date = date;
        this.isImportant = isImportant;
    }

    /**
     * Getter for contact name
     * @return Returns contact name
     */
    public Optional<String> getContactName() {
        return contactName;
    }

    /**
     * Getter for to field
     * @return Returns to
     */
    public String getTo() {
        return to;
    }

    /**
     * Getter for From field
     * @return Returns from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Getter for body
     * @return Returns body of message
     */
    public String getBody() {
        return body;
    }

    /**
     * Getter for date of message
     * @return Returns date of message
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Returns isImportant
     * @return isImportant variable
     */
    public boolean getIsImportant() {
        return isImportant;
    }
}
