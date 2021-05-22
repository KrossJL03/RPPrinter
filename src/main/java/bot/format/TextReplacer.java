package bot.format;

class TextReplacer
{
    private String regex;
    private String replacement;

    TextReplacer(String regex, String replacement)
    {
        this.regex = regex;
        this.replacement = replacement;
    }

    String replace(String text)
    {
        return text.replaceAll(regex, replacement);
    }
}
