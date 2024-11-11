import java.time.LocalDate;

public class Ztp05C {
    public static void main(String[] args) {
        Task task1 = new Task("1A - Implementacja algorytmu sortowania", LocalDate.of(2024, 10, 21), LocalDate.of(2024, 10, 27));
        Task task2 = new Task("1B - Analiza złożoności czasowej", LocalDate.of(2024, 10, 24), LocalDate.of(2024, 10, 31));
        Task task3 = new Task("2A - Projektowanie schematu bazy danych", LocalDate.of(2024, 10, 28), LocalDate.of(2024, 11, 3));
        Task task4 = new Task("2B - Tworzenie zapytań SQL", LocalDate.of(2024, 11, 1), LocalDate.of(2024, 11, 30));

        TaskGroup group1 = new TaskGroup("Grupa 1");
        group1.addComponent(task1);
        group1.addComponent(task2);

        TaskGroup group2 = new TaskGroup("Grupa 2");
        group2.addComponent(task3);
        group2.addComponent(task4);

        OptionalTaskGroup optionalGroup = new OptionalTaskGroup("Grupa Opcjonalna");
        optionalGroup.addComponent(task1);
        optionalGroup.addComponent(task2);
        optionalGroup.addComponent(task3);

        TaskGroup allTasks = new TaskGroup("Wszystkie zadania");
        allTasks.addComponent(group1);
        allTasks.addComponent(group2);
        allTasks.addComponent(optionalGroup);

        task1.markAsCompleted(LocalDate.of(2024, 10, 25)); // Wykonane na czas
        task2.markAsCompleted(LocalDate.of(2024, 11, 1));  // Wykonane z opóźnieniem

        System.out.println("Lista zadań:");
        allTasks.printTaskDetails("");

        System.out.println("\nPodsumowanie zadań:");
        System.out.println("Zadania wykonane na czas: " + allTasks.countCompletedOnTime());
        System.out.println("Zadania wykonane z opóźnieniem: " + allTasks.countCompletedLate());
        System.out.println("Zadania oczekujące: " + allTasks.countPending());
        System.out.println("Zadania oczekujące z przekroczonym terminem: " + allTasks.countPendingLate());

        // Mark the OptionalTaskGroup as completed and check the effect
        optionalGroup.markAsCompleted(LocalDate.of(2024, 11, 2));
        System.out.println("\nPo oznaczeniu grupy opcjonalnej jako wykonanej:");
        allTasks.printTaskDetails("");
    }
}
