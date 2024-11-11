import java.time.LocalDate;
import java.util.Random;

class OptionalTaskGroup extends TaskGroup {

    public OptionalTaskGroup(String name) {
        super(name);
    }

    @Override
    public void markAsCompleted(LocalDate completionDate) {
        boolean anyTaskCompleted = false;

        // Check if any task is completed, and if not, randomly complete one
        for (ITaskSystem component : components) {
            if (component.isCompleted()) {
                anyTaskCompleted = true;
                break;
            }
        }

        if (!anyTaskCompleted) {
            // Randomly mark one task as completed
            Random random = new Random();
            ITaskSystem taskToComplete = components.get(random.nextInt(components.size()));
            taskToComplete.markAsCompleted(completionDate);
        }
    }

    @Override
    public boolean isCompleted() {
        return components.stream().anyMatch(ITaskSystem::isCompleted);
    }
}