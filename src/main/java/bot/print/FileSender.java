package bot.print;

import bot.FormattedContent;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

/**
 * Sends files as attachment in discord messages
 */
class FileSender
{
    void write(MessageChannel channel, FormattedContent content, DateRange dateRange) throws IOException
    {
        String fileName = buildFileName(channel, content, dateRange);

        File file = new File(fileName);
        file.createNewFile();

        java.io.FileWriter myWriter = new java.io.FileWriter(fileName);
        myWriter.write(content.getContent());
        myWriter.close();

        channel.sendFile(file).queue();

        file.delete();
    }

    @NotNull
    private String buildFileName(MessageChannel channel, FormattedContent content, DateRange dateRange)
    {
        return String.format(
            "%s-%s-%s.%s",
            channel.getName(),
            content.getIdentifier(),
            dateRange.toString(),
            content.getFormat()
        );
    }
}
