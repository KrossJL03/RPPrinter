package bot.group;

import bot.Turn;
import bot.TurnRetriever;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public class GroupedMessageRetriever implements TurnRetriever
{
    private ChannelHistoryRetriever channelHistoryRetriever;
    private MessageGrouper          messageGrouper;
    private MessageListCleaner      messageListCleaner;

    GroupedMessageRetriever(
        ChannelHistoryRetriever channelHistoryRetriever,
        MessageGrouper messageGrouper,
        MessageListCleaner messageListCleaner
    )
    {
        this.channelHistoryRetriever = channelHistoryRetriever;
        this.messageGrouper = messageGrouper;
        this.messageListCleaner = messageListCleaner;
    }

    public List<Turn> retrieve(MessageChannel channel)
    {
        List<Message> channelHistory   = channelHistoryRetriever.retrieve(channel);
        List<Message> cleanMessageList = messageListCleaner.clean(channelHistory);

        return messageGrouper.group(cleanMessageList);
    }
}
