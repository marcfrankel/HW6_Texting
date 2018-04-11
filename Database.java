import java.util.Optional;
import java.time.LocalDateTime;
import java.util.function.Predicate;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


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
     * Function to get messages in DB with Priority
     * @return messages in DB with priority
     */
    public List<Message> getMessagesWithPriority() {
        Predicate<Message> prioritySearch = (Message::getIsImportant);

        return filter(prioritySearch);
    }

    /**
     * Method to sort messages by contact
     * @return Returns map of contact name and messages
     */
    public Map<String, List<Message>> sortMessagesByContact() {
        List<String> contacts = new ArrayList<String>();
        Map output = new HashMap();

        for (Message message : getMessages()) {
            Optional<String> contact = message.getContactName();
            if (contact.isPresent() && !contacts.contains(contact.get())) {
                contacts.add(contact.get());
            }
        }

        for (String contactName : contacts) {

            List<Message> temp = new ArrayList<Message>();

            for (Message m : filter(new CheckContact() {
                @Override
                public Predicate<Message> hasContact() {
                    return m -> m.getContactName().isPresent();
                }
            }
                .hasContact())) {
                if (m.getContactName().isPresent()) {
                    if (m.getContactName().get().equals(contactName)) {
                        temp.add(m);
                    }
                }
            }
            output.put(contactName, temp);
        }

        return output;
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
     * Inner class for keyword search
     */

    /**
     * Scafolding for checkContact
     */
    public class CheckContact {
        /**
         * Has contact scafold
         * @return null
         */
        public Predicate<Message> hasContact() {
            return null;
        }
    }

    /**
     * Inner Keyword class
     */
    public static class KeywordClass {

        /**
         * Function to look for keyword
         * @param  keyword keyword to look for
         * @return         true or false if keyword was there
         */
        public static Predicate<Message> hasKeyword(String keyword) {
            return m -> m.getBody().toLowerCase().contains(
                keyword.toLowerCase());
        }
    }

    /**
     * Gets message in DB with a specific keyword
     * @param  keyword keyword to search by
     * @return         messages with keyword
     */
    public List<Message> getMessagesWithKeyword(String keyword) {
        KeywordClass keySearch = new KeywordClass();

        return filter(KeywordClass.hasKeyword(keyword));

    }

    /**
     * Function to get messages between two dates
     * @param  start Start date to search
     * @param  end   End date to search
     * @return       Sorted message list
     */
    public List<Message> getMessagesBetween(LocalDateTime start,
        LocalDateTime end) {

        Predicate<Message> datesearch = mess -> (
            (mess.getDate().isAfter(start) && mess.getDate().isBefore(end))
            || (mess.getDate().equals(start) || mess.getDate().equals(end)));

        return filter(datesearch);
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