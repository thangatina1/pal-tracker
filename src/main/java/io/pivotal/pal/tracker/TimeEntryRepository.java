package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);
    public TimeEntry update(long timeEntryId, TimeEntry timeEntry);
    public TimeEntry read(long id);
    public List<TimeEntry> list();
    public void delete(long id);
    public TimeEntry find(long id);
}
