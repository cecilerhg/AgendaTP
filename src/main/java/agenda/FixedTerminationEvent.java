package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive event that terminates after a given date, or after
 * a given number of occurrences
 */
public class FixedTerminationEvent extends RepetitiveEvent {

    
    public LocalDate dateFin;
    public long occurences;
    
    /**
     * Constructs a fixed terminationInclusive event ending at a given date
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param terminationInclusive the date when this event ends
     */

    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, LocalDate terminationInclusive) {
        super(title, start, duration, frequency);
        this.dateFin = terminationInclusive;
        this.occurences = calculOccurrences();
    }

    /**
     * Constructs a fixed termination event ending after a number of iterations
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     * @param numberOfOccurrences the number of occurrences of this repetitive event
     */
    public FixedTerminationEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, long numberOfOccurrences) {
        super(title, start, duration, frequency);
        this.dateFin = calculDateFin() ;
        this.occurences = numberOfOccurrences;
    }

    /**
     *
     * @return the termination date of this repetitive event
     */
    public LocalDate getTerminationDate() {
        return dateFin;  
    }

    public long getNumberOfOccurrences() {
        return occurences;
    }
    
    private LocalDate calculDateFin() {
        switch (this.frequency) {
            case DAYS:
                return this.getStart().plus(this.getNumberOfOccurrences() - 1, ChronoUnit.DAYS).toLocalDate();
            case WEEKS:
                return this.getStart().plus(this.getNumberOfOccurrences() - 1, ChronoUnit.WEEKS).toLocalDate();
            case MONTHS:
                return this.getStart().plus(this.getNumberOfOccurrences() - 1, ChronoUnit.MONTHS).toLocalDate();
            default:
                return this.getStart().toLocalDate();
        }
    }
    
    public long calculOccurrences(){
        return this.getStart().toLocalDate().until(dateFin, frequency) + 1;
    }
    
    @Override
    public String toString() {
        return "Titre: " + this.getTitle() + " Durée : " + this.getDuration() + " Fréquence: " + this.getFrequency() + " Nb occurences : " + this.getNumberOfOccurrences() + " Date fin : " + this.getTerminationDate();
    }
}
