package bot.stats;

import bot.FormattedContent;
import bot.Turn;
import bot.TurnFormatter;

import java.util.List;

class StatsCalculator
{
    private TurnFormatter turnFormatter;

    StatsCalculator(TurnFormatter turnFormatter)
    {
        this.turnFormatter = turnFormatter;
    }

    Stats calculate(List<Turn> turnList)
    {
        FormattedContent content = turnFormatter.format(turnList);
        String[]         words   = content.getContent().split(" ");

        return new Stats(content.getIdentifier(), turnList.size(), words.length);
    }
}
