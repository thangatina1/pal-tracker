package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

  //  @Autowired
    //public TimeEntry timeEntry = new TimeEntry();

    /*public InMemoryTimeEntryRepository(TimeEntry timeEntry) {
        this.timeEntry = timeEntry;
    }*/

    public InMemoryTimeEntryRepository() {
    }

    public long idGenerator = 0;
    HashMap<Long, TimeEntry> timeEntryMap = new HashMap<Long, TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        idGenerator++;
        timeEntry.setId(idGenerator);
        timeEntryMap.put(timeEntry.getId(),timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry uptimeEntry) {
        uptimeEntry.setId(timeEntryId);
        if (timeEntryMap.replace(timeEntryId,uptimeEntry) != null)
            return uptimeEntry;
        else
            return null;
    }

    @Override
    public TimeEntry read(long id) {
        return(timeEntryMap.get(id));
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> timeEntryout = new ArrayList(timeEntryMap.values());
        for(TimeEntry printls: timeEntryout)
           System.out.println("Values in list:" + printls.getId() + "," + printls.getProjectId()) ;
        return (timeEntryout);
    }

    @Override
    public void delete(long id) {
        timeEntryMap.remove(id);
    }


    @Override
    public TimeEntry find(long id) {
        return (timeEntryMap.get(id));
    }
}
