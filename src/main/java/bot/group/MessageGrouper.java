package bot.group;

import bot.Turn;
import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Groups messages by author. If an author posted multiple messages in a row they will be considered one message
 */
class MessageGrouper
{
    MessageGrouper()
    {
    }

    List<Turn> group(List<Message> messageList)
    {
        List<Turn>    groupedMessageList = new ArrayList<>();
        StringBuilder stringBuilder      = new StringBuilder();
        Queue<Message> messageQueue = new LinkedList<Message>()
        {
            {
                addAll(messageList);
            }
        };

        do {
            Message message = messageQueue.poll();
            assert message != null;

            if (stringBuilder.length() != 0) {
                stringBuilder.append(System.getProperty("line.separator"));
                stringBuilder.append(System.getProperty("line.separator"));
            }
            stringBuilder.append(message.getContentRaw());

            if (stringBuilder.length() > 0 && (messageQueue.isEmpty() || !isSameAuthor(message, messageQueue.peek()))) {
                groupedMessageList.add(new GroupedMessage(stringBuilder.toString()));

                stringBuilder = new StringBuilder();
            }

        } while (!messageQueue.isEmpty());

        return groupedMessageList;
    }

    private boolean isSameAuthor(Message message, Message nextMessage)
    {
        return message.getAuthor().getId().equals(nextMessage.getAuthor().getId());
    }
}
