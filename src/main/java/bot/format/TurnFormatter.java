package bot.format;

import bot.Turn;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Formats discord messages to fit another format type
 */
class TurnFormatter implements bot.TurnFormatter
{
    private Format        format;
    private String        identifier;
    private TextCensorer  textCensorer;
    private TextCleaner   textCleaner;
    private TextFormatter textFormatter;
    private String        turnBreak;

    TurnFormatter(
        String identifier,
        Format format,
        TextCensorer textCensorer,
        TextFormatter textFormatter,
        String turnBreak,
        TextCleaner textCleaner
    )
    {
        this.identifier = identifier;
        this.textCensorer = textCensorer;
        this.textFormatter = textFormatter;
        this.turnBreak = turnBreak;
        this.format = format;
        this.textCleaner = textCleaner;
    }

    public bot.FormattedContent format(List<Turn> turnList)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (Turn turn : turnList) {
            String text = textFormatter.format(textCensorer.censor(clean(turn)));
            if (text.length() > 0) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(turnBreak);
                }
                stringBuilder.append(text);
            }
        }

        return new FormattedContent(stringBuilder.toString(), format, identifier);
    }

    @NotNull
    private String clean(Turn turn)
    {
        return textCleaner.clean(turn.toString().trim());
    }
}
