package bot.stats;

import bot.EventHandler;
import bot.Turn;
import bot.TurnRetriever;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class StatsEventHandler extends EventHandler
{
    private List<StatsCalculator> statsCalculatorList;

    StatsEventHandler(
        String command,
        List<StatsCalculator> statsCalculatorList,
        TurnRetriever turnRetriever
    )
    {
        super(command, turnRetriever);

        this.statsCalculatorList = statsCalculatorList;
    }

    public void handle(MessageReceivedEvent event)
    {
        List<Turn> turnList = retrieveTurns(event);

        for (StatsCalculator statsCalculator : statsCalculatorList) {
            Stats stats = statsCalculator.calculate(turnList);
            printStats(event.getChannel(), stats);
        }
    }

    private void printStats(MessageChannel channel, Stats stats)
    {
        String print = String.format(
            "```asciidoc\n" +
            "%s\n" +
            "================\n" +
            "Turns :: %s\n" +
            "Words :: %s\n" +
            "```",
            stats.getName().toUpperCase(),
            stats.getTurnCount(),
            stats.getWordCount()
        );

        channel.sendMessage(print).queue();
    }
}
