package bot.group;

import net.dv8tion.jda.api.entities.Message;

import java.util.List;

public interface MessageListCleaner
{
    List<Message> clean(List<Message> messageList);
}
