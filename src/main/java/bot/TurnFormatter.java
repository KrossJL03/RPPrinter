package bot;

import java.util.List;

public interface TurnFormatter
{
    FormattedContent format(List<Turn> turnList);
}
