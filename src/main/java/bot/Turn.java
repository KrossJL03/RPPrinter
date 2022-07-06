package bot;

import java.time.OffsetDateTime;

public interface Turn
{
    String getAuthor();

    String getMessage();

    OffsetDateTime getPostedAt();
}
