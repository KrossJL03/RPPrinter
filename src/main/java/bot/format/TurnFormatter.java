package bot.format;

import bot.Turn;

import java.util.List;

/**
 * Formats discord messages to fit another format type
 */
class TurnFormatter implements bot.TurnFormatter
{
    private Format              format;
    private TurnHeaderGenerator headerGenerator;
    private String              identifier;
    private TextCensorer        textCensorer;
    private TextCleaner         textCleaner;
    private TextFormatter       textFormatter;
    private String              turnBreak;

    TurnFormatter(
        String identifier,
        Format format,
        TextCensorer textCensorer,
        TextFormatter textFormatter,
        String turnBreak,
        TextCleaner textCleaner,
        TurnHeaderGenerator headerGenerator
    )
    {
        this.identifier = identifier;
        this.textCensorer = textCensorer;
        this.textFormatter = textFormatter;
        this.turnBreak = turnBreak;
        this.format = format;
        this.textCleaner = textCleaner;
        this.headerGenerator = headerGenerator;
    }

    public bot.FormattedContent format(List<Turn> turnList)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (Turn turn : turnList) {
            String text = textFormatter.formatMessage(textCensorer.censor(textCleaner.clean(turn.getMessage().trim())));
            if (text.length() > 0) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(turnBreak);
                }

                String header = headerGenerator.generate(turn);
                if (header.length() > 0) {
                    stringBuilder.append(header);
                    stringBuilder.append("\n");
                }

                stringBuilder.append(text);
            }
        }

        return new FormattedContent(stringBuilder.toString(), format, identifier);
    }
}
