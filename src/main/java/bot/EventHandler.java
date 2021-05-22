package bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.IOException;
import java.util.List;

public abstract class EventHandler
{
    private String        command;
    private TurnRetriever turnRetriever;

    protected EventHandler(
        String command,
        TurnRetriever turnRetriever
    )
    {
        this.command = command;
        this.turnRetriever = turnRetriever;
    }

    public abstract void handle(MessageReceivedEvent event) throws IOException;

    boolean handles(MessageReceivedEvent event)
    {
        return event.getMessage().getContentRaw().trim().equals(command);
    }

    final protected List<Turn> retrieveTurns(MessageReceivedEvent event)
    {
        return turnRetriever.retrieve(event.getChannel());
    }
}
