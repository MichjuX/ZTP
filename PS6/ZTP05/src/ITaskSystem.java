import java.time.LocalDate;

// Interfejs wspólny dla Task oraz TaskGroup
interface ITaskSystem {
    String getName();
    boolean isCompleted();
    LocalDate getStartDate();
    LocalDate getEndDate();
    void markAsCompleted(LocalDate completionDate);
    String getStatus();
    void printTaskDetails(String indent);
}