package bot.group;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

class ChannelHistoryRetriever
{
    @NotNull
    List<Message> retrieve(MessageChannel channel)
    {
        List<Message> channelMessageList = new ArrayList<>();
        List<Message> retrievedHistory = channel.getHistoryFromBeginning(100)
                                                .complete()
                                                .getRetrievedHistory();

        while (!retrievedHistory.isEmpty()) {
            channelMessageList.addAll(retrievedHistory);
            retrievedHistory = channel.getHistoryAfter(retrievedHistory.get(0), 100)
                                      .complete()
                                      .getRetrievedHistory();
        }

        channelMessageList.sort(new MessageComparator());

        return channelMessageList;
    }
}
