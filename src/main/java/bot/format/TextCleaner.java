package bot.format;

import java.util.List;

/**
 * Removes specified characters and strings from text
 */
class TextCleaner
{
    private List<TextReplacer> replacerList;

    TextCleaner(List<TextReplacer> replacerList)
    {
        this.replacerList = replacerList;
    }

    String clean(String text)
    {
        for (TextReplacer replacer : replacerList) {
            text = replacer.replace(text);
        }

        return text.trim();
    }
}
