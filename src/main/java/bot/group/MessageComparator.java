package bot.group;

import net.dv8tion.jda.api.entities.Message;

import java.util.Comparator;

class MessageComparator implements Comparator<Message>
{
    @Override
    public int compare(Message messageOne, Message messageTwo)
    {
        return messageOne.getTimeCreated().compareTo(messageTwo.getTimeCreated());
    }
}
