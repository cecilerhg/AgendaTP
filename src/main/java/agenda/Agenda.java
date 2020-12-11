package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
   public HashSet<Event> mesEvents = new HashSet<Event>();

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        this.mesEvents.add(e);

    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> today = new ArrayList();
        for (Event e : mesEvents) {
            if (e.isInDay(day)) {
                today.add(e);
            }

        }
        return today;
    }
}
