package bot.print;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

class DateRange
{
    private OffsetDateTime endedAt;
    private OffsetDateTime startedAt;

    DateRange(OffsetDateTime startedAt, OffsetDateTime endedAt)
    {
        this.endedAt = endedAt;
        this.startedAt = startedAt;
    }

    @Override
    public String toString()
    {
        return String.format(
            "%s-to-%s",
            startedAt.format(DateTimeFormatter.ISO_LOCAL_DATE),
            endedAt.format(DateTimeFormatter.ISO_LOCAL_DATE)
        );
    }
}
