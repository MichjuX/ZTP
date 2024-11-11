import java.time.LocalDate;

class Task implements ITaskSystem {
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private boolean isCompleted = false;
    private boolean isLate = false;

    public Task(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void markAsCompleted(LocalDate completionDate) {
        if (!isCompleted) {
            isCompleted = true;
            isLate = completionDate.isAfter(endDate);
        }
    }

    public String getStatus() {
        if (isCompleted) {
            return isLate ? "[Completed Late]" : "[Completed]";
        }
        return "[Pending]";
    }

    @Override
    public String toString() {
        return name + " (" + startDate + " to " + endDate + ") - Status: " + getStatus();
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public boolean isLate() {
        return isLate;
    }

    public void printTaskDetails(String indent) {
        System.out.println(indent + toString());
    }
}