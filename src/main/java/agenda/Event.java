package agenda;

import java.time.*;
import java.time.chrono.ChronoLocalDate;

public class Event {

  /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        if (aDay.isEqual(ChronoLocalDate.from(this.myStart)) || aDay.isEqual(ChronoLocalDate.from(this.myStart.plus(this.myDuration))) || aDay.isBefore(ChronoLocalDate.from(this.myStart.plus(this.myDuration))) && aDay.isAfter(ChronoLocalDate.from(this.myStart))) {
            return true;
            
        } else {
            return false;
        }
            
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

   //ToString   
    public String toString() {
        return "Titre événement : " + this.getTitle() + "Début: " + this.getStart() + "Durée: " + this.getDuration() ;
    }
    
}
