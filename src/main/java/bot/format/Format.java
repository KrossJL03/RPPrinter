package bot.format;

class Format
{
    private static final String FORMAT_HTML = "html";
    private static final String FORMAT_RAW  = "raw";

    private String value;

    private Format(String value)
    {
        this.value = value;
    }

    static Format html()
    {
        return new Format(FORMAT_HTML);
    }

    static Format raw()
    {
        return new Format(FORMAT_HTML);
    }

    @Override
    public String toString()
    {
        return value;
    }
}
