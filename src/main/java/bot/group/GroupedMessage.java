package bot.group;

import bot.Turn;

import java.time.OffsetDateTime;

/**
 * String representation of consecutive messages from a single author
 */
public class GroupedMessage implements Turn
{
    private String         message;
    private OffsetDateTime postedAt;

    GroupedMessage(String message, OffsetDateTime postedAt)
    {
        this.message = message;
        this.postedAt = postedAt;
    }

    @Override
    public OffsetDateTime getPostedAt()
    {
        return postedAt;
    }

    @Override
    public String toString()
    {
        return message;
    }
}
