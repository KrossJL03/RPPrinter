package bot.print;

import bot.EventHandler;
import bot.Turn;
import bot.TurnFormatter;
import bot.TurnRetriever;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.util.List;

class PrintEventHandler extends EventHandler
{
    private FileSender          fileSender;
    private List<TurnFormatter> formatterList;

    PrintEventHandler(
        String command,
        List<TurnFormatter> formatterList,
        FileSender fileSender,
        TurnRetriever turnRetriever
    )
    {
        super(command, turnRetriever);

        this.formatterList = formatterList;
        this.fileSender = fileSender;
    }

    public void handle(MessageReceivedEvent event) throws IOException
    {
        MessageChannel channel   = event.getChannel();
        List<Turn>     turnList  = retrieveTurns(event);
        DateRange      dateRange = buildDateRange(turnList);

        for (TurnFormatter formatter : formatterList) {
            fileSender.write(channel, formatter.format(turnList), dateRange);
        }
    }

    private DateRange buildDateRange(List<Turn> turnList)
    {
        Turn firstTurn = turnList.get(0);
        Turn lastTurn  = turnList.get(turnList.size() - 1);

        return new DateRange(firstTurn.getPostedAt(), lastTurn.getPostedAt());
    }
}
