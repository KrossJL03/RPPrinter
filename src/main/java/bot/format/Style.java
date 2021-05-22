package bot.format;

class Style
{
    private String basic;
    private String regex;

    Style(String basic, String regex)
    {
        this.basic = basic;
        this.regex = regex;
    }

    String getBasic()
    {
        return basic;
    }

    String getRegex()
    {
        return regex;
    }
}
