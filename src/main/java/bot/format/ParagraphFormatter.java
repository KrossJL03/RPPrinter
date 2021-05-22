package bot.format;

class ParagraphFormatter
{
    private String closing;
    private String opening;

    ParagraphFormatter(String opening, String closing)
    {
        this.opening = opening;
        this.closing = closing;
    }

    String format(String paragraph)
    {
        return opening + paragraph + closing;
    }
}
