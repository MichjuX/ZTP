import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class TaskGroup implements ITaskSystem {
    private final String name;
    public final List<ITaskSystem> components = new ArrayList<>();

    public TaskGroup(String name) {
        this.name = name;
    }

    public void addComponent(ITaskSystem component) {
        components.add(component);
    }

    public void markAsCompleted(LocalDate completionDate) {
        for (ITaskSystem component : components) {
            component.markAsCompleted(completionDate);
        }
    }

    public String getStatus() {
        return isCompleted() ? "[Completed]" : "[Pending]";
    }

    public boolean isCompleted() {
        return components.stream().allMatch(ITaskSystem::isCompleted);
    }

    public LocalDate getStartDate() {
        return components.stream()
                .map(ITaskSystem::getStartDate)
                .min(LocalDate::compareTo)
                .orElse(null);
    }

    public LocalDate getEndDate() {
        return components.stream()
                .map(ITaskSystem::getEndDate)
                .max(LocalDate::compareTo)
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public void printTaskDetails(String indent) {
        System.out.println(indent + name + " - Status: " + getStatus());
        for (ITaskSystem component : components) {
            component.printTaskDetails(indent + "  ");
        }
    }

    public long countCompletedOnTime() {
        return components.stream()
                .filter(c -> c.isCompleted() && c.getStatus().equals("[Completed]"))
                .count();
    }

    public long countCompletedLate() {
        return components.stream()
                .filter(c -> c.isCompleted() && c.getStatus().equals("[Completed Late]"))
                .count();
    }

    public long countPending() {
        return components.stream()
                .filter(c -> !c.isCompleted())
                .count();
    }

    public long countPendingLate() {
        return components.stream()
                .filter(c -> !c.isCompleted() && LocalDate.now().isAfter(c.getEndDate()))
                .count();
    }
}