package bot.format;

/**
 * Content that has been reformatted to fit a given style
 */
class FormattedContent implements bot.FormattedContent
{
    private String content;
    private Format format;
    private String identifier;

    FormattedContent(String content, Format format, String identifier)
    {
        this.content = content;
        this.identifier = identifier;
        this.format = format;
    }

    public String getContent()
    {
        return content;
    }

    public String getFormat()
    {
        return format.toString();
    }

    public String getIdentifier()
    {
        return identifier;
    }
}
