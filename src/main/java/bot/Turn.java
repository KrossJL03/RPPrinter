package bot;

import java.time.OffsetDateTime;

public interface Turn
{
    OffsetDateTime getPostedAt();

    String toString();
}
