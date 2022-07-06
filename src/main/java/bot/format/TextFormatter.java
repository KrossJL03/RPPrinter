package bot.format;

import java.util.List;

class TextFormatter
{
    private ParagraphFormatter            paragraphFormatter;
    private List<ReplaceableStyleTracker> styleTrackerList;

    TextFormatter(List<ReplaceableStyleTracker> styleTrackerList, ParagraphFormatter paragraphFormatter)
    {
        this.styleTrackerList = styleTrackerList;
        this.paragraphFormatter = paragraphFormatter;
    }

    String formatMessage(String text)
    {
        clearTrackers();

        StringBuilder resultBuilder = new StringBuilder();
        for (String paragraph : text.split("\n\n")) {
            String formattedParagraph = formatParagraph(paragraph);
            if (formattedParagraph.length() > 0) {
                if (resultBuilder.length() > 0) {
                    resultBuilder.append("\n");
                }

                resultBuilder.append(formattedParagraph);
            }
        }

        return resultBuilder.toString();
    }

    private void clearTrackers()
    {
        for (ReplaceableStyleTracker tracker : styleTrackerList) {
            tracker.clear();
        }
    }

    private String formatParagraph(String paragraph)
    {
        StringBuilder paragraphBuilder = new StringBuilder();
        paragraphBuilder.append(paragraph);

        for (ReplaceableStyleTracker styleTracker : styleTrackerList) {
            if (styleTracker.isOpen()) {
                paragraphBuilder.insert(0, styleTracker.getOpening());
            }

            while (paragraphBuilder.indexOf(styleTracker.getStyle().getBasic()) > -1) {
                int indexOf = paragraphBuilder.indexOf(styleTracker.getStyle().getBasic());
                paragraphBuilder.replace(
                    indexOf,
                    indexOf + styleTracker.getStyle().getBasic().length(),
                    styleTracker.isOpen()
                    ? styleTracker.getClosing()
                    : styleTracker.getOpening()
                );
                styleTracker.toggle();
            }

            if (styleTracker.isOpen()) {
                paragraphBuilder.append(styleTracker.getClosing());
            }
        }

        String formattedParagraph = paragraphBuilder.toString().trim();

        return formattedParagraph.length() > 0
               ? paragraphFormatter.format(formattedParagraph)
               : formattedParagraph;
    }
}
