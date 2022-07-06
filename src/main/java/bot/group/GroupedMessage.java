package bot.group;

import bot.Turn;

import java.time.OffsetDateTime;

/**
 * String representation of consecutive messages from a single author
 */
public class GroupedMessage implements Turn
{
    private String         author;
    private String         message;
    private OffsetDateTime postedAt;

    GroupedMessage(String message, OffsetDateTime postedAt, String author)
    {
        this.message = message;
        this.postedAt = postedAt;
        this.author = author;
    }

    @Override
    public String getAuthor()
    {
        return author;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    @Override
    public OffsetDateTime getPostedAt()
    {
        return postedAt;
    }
}
