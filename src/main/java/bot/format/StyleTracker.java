package bot.format;

/**
 * Helper class used to record stylistic formatting in text
 */
class StyleTracker
{
    private boolean isOpen;
    private Style   style;

    StyleTracker(Style style)
    {
        this.style = style;

        this.isOpen = false;
    }

    void clear()
    {
        isOpen = false;
    }

    Style getStyle()
    {
        return style;
    }

    boolean isOpen()
    {
        return isOpen;
    }

    void toggle()
    {
        isOpen = !isOpen;
    }
}
