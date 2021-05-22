package bot.format;

import java.util.List;

class TextCensorer
{
    private List<StyleTracker> styleTrackerList;

    TextCensorer(List<StyleTracker> styleTrackerList)
    {
        this.styleTrackerList = styleTrackerList;
    }

    String censor(String text)
    {
        clearTrackers();

        StringBuilder resultBuilder = new StringBuilder();
        for (String paragraph : text.split("\n\n")) {
            String formattedParagraph = censorParagraph(paragraph);
            if (formattedParagraph.length() > 0) {
                if (resultBuilder.length() > 0) {
                    resultBuilder.append("\n\n");
                }

                resultBuilder.append(formattedParagraph);
            }
        }

        return resultBuilder.toString();
    }

    private String censorParagraph(String paragraph)
    {
        for (StyleTracker tracker : styleTrackerList) {
            boolean startsWithTag   = paragraph.startsWith(tracker.getStyle().getBasic());
            int     occurrenceCount = countOccurrences(tracker.getStyle().getBasic(), paragraph);

            if (tracker.isOpen() && !startsWithTag) {
                paragraph = tracker.getStyle().getBasic() + paragraph;
            }

            if (occurrenceCount % 2 != 0) {
                tracker.toggle();
            }

            StringBuilder paragraphBuilder = new StringBuilder();
            String[]      paragraphPieces  = paragraph.split(tracker.getStyle().getRegex());
            for (int i = 0; i < paragraphPieces.length; i = i + 2) {
                String trimmedPiece = paragraphPieces[i].trim();
                if (trimmedPiece.length() > 0) {
                    if (paragraphBuilder.length() > 0) {
                        paragraphBuilder.append(" ");
                    }
                    paragraphBuilder.append(trimmedPiece);
                }
            }

            paragraph = paragraphBuilder.toString().trim();
        }

        return paragraph;
    }

    private void clearTrackers()
    {
        for (StyleTracker tracker : styleTrackerList) {
            tracker.clear();
        }
    }

    private int countOccurrences(String needle, String haystack)
    {
        int count     = 0;
        int lastIndex = 0;

        while (lastIndex != -1) {
            lastIndex = haystack.indexOf(needle, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += needle.length();
            }
        }

        return count;
    }
}
