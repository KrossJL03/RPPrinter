package bot.stats;

class Stats
{
    private String name;
    private int    turnCount;
    private int    wordCount;

    Stats(String name, int turnCount, int wordCount)
    {
        this.name = name;
        this.turnCount = turnCount;
        this.wordCount = wordCount;
    }

    String getName()
    {
        return name;
    }

    int getTurnCount()
    {
        return turnCount;
    }

    int getWordCount()
    {
        return wordCount;
    }
}
