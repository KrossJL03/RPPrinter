package bot.group;

import bot.Turn;

/**
 * String representation of consecutive messages from a single author
 */
public class GroupedMessage implements Turn
{
    private String message;

    GroupedMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return message;
    }
}
