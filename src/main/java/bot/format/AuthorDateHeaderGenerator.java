package bot.format;

import bot.Turn;

import java.time.format.DateTimeFormatter;

class AuthorDateHeaderGenerator implements TurnHeaderGenerator
{
    public String generate(Turn turn)
    {
        return turn.getAuthor().toUpperCase()
               + " ["
               + turn.getPostedAt().format(DateTimeFormatter.RFC_1123_DATE_TIME)
               + "]";
    }
}
