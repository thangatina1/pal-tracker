package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {


    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

//    @Autowired
//    public TimeEntry timeEntry = new TimeEntry();

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntry);
        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry updatedTimeEntry = timeEntryRepository.update(id, timeEntry);
        if (updatedTimeEntry != null) {
            return new ResponseEntity<TimeEntry>(updatedTimeEntry, HttpStatus.OK);}
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id){
        TimeEntry readTimeEntry = timeEntryRepository.find(id);
        if (readTimeEntry != null){
            return new ResponseEntity<TimeEntry>(readTimeEntry, HttpStatus.OK);}
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> listTimeEntry = new ArrayList<TimeEntry>();
        listTimeEntry = timeEntryRepository.list();
        if (listTimeEntry != null) {
            return new ResponseEntity<List<TimeEntry>>(listTimeEntry, HttpStatus.OK);}
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        timeEntryRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public TimeEntry find(long id) {
        return (new TimeEntry (111L,111L, LocalDate.parse("2017-01-08"), 8));
    }
}