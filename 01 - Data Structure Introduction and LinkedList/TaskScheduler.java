class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    private Task head;

    public CircularTaskList() {
        this.head = null;
    }

    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            head = newTask;
        }
    }

    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task temp = head;
        int count = 0;
        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp.next == head || count == position - 1) {
            newTask.next = temp.next;
            temp.next = newTask;
        } else {
            System.out.println("Position out of bounds");
        }
    }

    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
            } else {
                Task temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
        } else {
            Task temp = head;
            while (temp.next != head && temp.next.taskId != taskId) {
                temp = temp.next;
            }
            if (temp.next != head) {
                temp.next = temp.next.next;
            } else {
                System.out.println("Task with ID " + taskId + " not found.");
            }
        }
    }

    public void displayCurrentTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
    }

    public void moveToNextTask() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        head = head.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public Task searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return null;
        }
        Task temp = head;
        do {
            if (temp.priority == priority) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        CircularTaskList taskList = new CircularTaskList();

        taskList.addTaskAtBeginning(1, "Task 1", 3, "2023-12-01");
        taskList.addTaskAtEnd(2, "Task 2", 1, "2023-12-02");
        taskList.addTaskAtPosition(3, "Task 3", 2, "2023-12-03", 1);

        System.out.println("All tasks in the list:");
        taskList.displayAllTasks();

        System.out.println("\nCurrent Task:");
        taskList.displayCurrentTask();

        taskList.moveToNextTask();
        System.out.println("\nAfter moving to next task:");
        taskList.displayCurrentTask();

        taskList.removeTaskById(2);

        System.out.println("\nTasks after removal:");
        taskList.displayAllTasks();

        Task task = taskList.searchTaskByPriority(3);
        if (task != null) {
            System.out.println("\nTask with priority 3 found: " + task.taskName);
        } else {
            System.out.println("\nTask with priority 3 not found.");
        }
    }
}
