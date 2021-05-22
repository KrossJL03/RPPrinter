package bot.format;

/**
 * Helper class used to record stylistic formatting in text and supply replacement text for such styles
 */
class ReplaceableStyleTracker extends StyleTracker
{
    private String closing;
    private String opening;

    ReplaceableStyleTracker(Style style, String opening, String closing)
    {
        super(style);
        this.closing = closing;
        this.opening = opening;
    }

    String getClosing()
    {
        return closing;
    }

    String getOpening()
    {
        return opening;
    }
}
