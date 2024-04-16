package task;

public interface TaskUpdate {
    void addTaskUpdateObserver(TaskUpdateObserver observer);
    void removeTaskUpdateObserver(TaskUpdateObserver observer);
}
