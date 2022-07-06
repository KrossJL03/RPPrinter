package bot.format;

import bot.Turn;

public class NullHeaderGenerator implements TurnHeaderGenerator
{
    public String generate(Turn turn)
    {
        return "";
    }
}
