package bot.group;

import net.dv8tion.jda.api.entities.Message;

import java.util.ArrayList;
import java.util.List;

class BotCommandCleaner implements MessageListCleaner
{
    private List<String> commandList;

    BotCommandCleaner(List<String> commandList)
    {
        this.commandList = commandList;
    }

    public List<Message> clean(List<Message> messageList)
    {
        List<Message> result = new ArrayList<>();
        for (Message message : messageList) {
            if (!message.getAuthor().isBot() && !isCommand(message)) {
                result.add(message);
            }
        }

        return result;
    }

    private boolean isCommand(Message message)
    {
        return commandList.contains(message.getContentRaw().trim());
    }
}
