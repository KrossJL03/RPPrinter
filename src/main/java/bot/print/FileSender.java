package bot.print;

import bot.FormattedContent;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.io.File;
import java.io.IOException;

/**
 * Sends files as attachment in discord messages
 */
class FileSender
{
    void write(MessageChannel channel, FormattedContent content) throws IOException
    {
        String fileName = channel.getName() + "-" + content.getIdentifier() + "." + content.getFormat();

        File file = new File(fileName);
        file.createNewFile();

        java.io.FileWriter myWriter = new java.io.FileWriter(fileName);
        myWriter.write(content.getContent());
        myWriter.close();

        channel.sendFile(file).queue();

        file.delete();
    }
}
