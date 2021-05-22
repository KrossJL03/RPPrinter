package bot;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * Entry point for a given event
 */
class EventListener extends ListenerAdapter
{
    private EventHandler eventHandler;

    EventListener(EventHandler eventHandler)
    {
        this.eventHandler = eventHandler;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event)
    {
        try {
            if (eventHandler.handles(event)) {
                eventHandler.handle(event);
            }
        } catch (Throwable exception) {
            event.getChannel().sendMessage(exception.getMessage()).queue();
        }
    }
}