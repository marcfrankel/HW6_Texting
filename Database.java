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


    public Database(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Message> filter(Predicate<Message> filter) {
        List<Message> outputList = new ArrayList<Message>();
        for (Message message : messages) {
            if (filter.test(message)) {
                outputList.add(message);
            }
        }
        return outputList;
    }

    public List<Message> getMessagesWithKeyword(String keyword) {
        List<Message> output = messages;
        keyword = keyword.toLowerCase();


        return output;

    }

    public Message getMessage(int n) {
        return messages.get(n);
    }
}