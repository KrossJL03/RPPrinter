package bot.group;

import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlreadyPrintedMessageCleaner implements MessageListCleaner
{
    private List<String> printCommandList;

    AlreadyPrintedMessageCleaner(List<String> printCommandList)
    {
        this.printCommandList = printCommandList;
    }

    public List<Message> clean(List<Message> messageList)
    {
        Collections.reverse(messageList);
        List<Message> result                    = new ArrayList<>();
        boolean       hasNonPrintCommandMessage = false;
        for (Message message : messageList) {
            result.add(message);
            if (!message.getAuthor().isBot() && !isPrintCommand(message)) {
                hasNonPrintCommandMessage = true;
            } else if (hasNonPrintCommandMessage) {
                break;
            }
        }

        Collections.reverse(result);

        return result;
    }

    private boolean isPrintCommand(Message message)
    {
        return printCommandList.contains(message.getContentRaw().trim());
    }
}
