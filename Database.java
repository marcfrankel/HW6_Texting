import java.util.Optional;
import java.time.LocalDateTime;
import java.util.function.Predicate;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


/**
 * A simple database class for the texting hw
 * @author mfrankel8
 * @version 1.0
 * 4/10/18
**/

public class Database {

    private List<Message> messages;


    /**
     * Public Database contructor
     * @param  messages List of messages in DB
     *
     */
    public Database(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Getter for messages
     * @return returns messages in the db
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Filter function for db
     * @param  filter Predicate to do the filter
     * @return        Returns a List-message- that has been filtered
     */
    public List<Message> filter(Predicate<Message> filter) {
        List<Message> outputList = new ArrayList<Message>();
        for (Message message : messages) {
            if (filter.test(message)) {
                outputList.add(message);
            }
        }
        return outputList;
    }

    /**
     * Gets message in DB with a specific keyword
     * @param  keyword keyword to search by
     * @return         messages with keyword
     */
    public List<Message> getMessagesWithKeyword(String keyword) {
        List<Message> output = messages;
        keyword = keyword.toLowerCase();


        return output;

    }

    /**
     * Getter for a Message
     * @param  n Nth message in DB to get
     * @return   Nth Message in DB
     */
    public Message getMessage(int n) {
        return messages.get(n);
    }
}