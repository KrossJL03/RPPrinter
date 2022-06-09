package bot.group;

import bot.Turn;
import bot.TurnRetriever;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class GroupedMessageRetriever implements TurnRetriever
{
    private ChannelHistoryRetriever  channelHistoryRetriever;
    private MessageGrouper           messageGrouper;
    private List<MessageListCleaner> messageListCleanerList;

    GroupedMessageRetriever(
        ChannelHistoryRetriever channelHistoryRetriever,
        MessageGrouper messageGrouper,
        List<MessageListCleaner> messageListCleanerList
    )
    {
        this.channelHistoryRetriever = channelHistoryRetriever;
        this.messageGrouper = messageGrouper;
        this.messageListCleanerList = messageListCleanerList;
    }

    public List<Turn> retrieve(MessageChannel channel)
    {
        List<Message> messageList = channelHistoryRetriever.retrieve(channel);
        for (MessageListCleaner cleaner : messageListCleanerList) {
            messageList = cleaner.clean(messageList);
        }

        return messageGrouper.group(messageList);
    }
}
