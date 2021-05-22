package bot;

import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.List;

public interface TurnRetriever
{
    List<Turn> retrieve(MessageChannel channel);
}
