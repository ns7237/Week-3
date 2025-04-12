import java.util.*;

class Process {
    int id, burstTime, remainingTime, priority;
    Process next;
    public Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;
    private Map<Integer, Integer> waitingTimeMap = new HashMap<>();
    private Map<Integer, Integer> turnAroundTimeMap = new HashMap<>();

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    public void runScheduling() {
        if (head == null) return;
        int currentTime = 0;
        Process current = head;
        while (head != null) {
            if (current.remainingTime > 0) {
                int executedTime = Math.min(current.remainingTime, timeQuantum);
                currentTime += executedTime;
                current.remainingTime -= executedTime;
                displayQueue();
                if (current.remainingTime == 0) {
                    turnAroundTimeMap.put(current.id, currentTime);
                    waitingTimeMap.put(current.id, currentTime - current.burstTime);
                    removeProcess(current.id);
                }
            }
            current = current.next;
        }
        printAvgTimes();
    }

    public void displayQueue() {
        if (head == null) return;
        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("[P" + temp.id + ", R:" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public void removeProcess(int id) {
        if (head == null) return;
        Process current = head;
        Process prev = tail;
        do {
            if (current.id == id) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head) head = head.next;
                    if (current == tail) tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void printAvgTimes() {
        int totalWaiting = 0, totalTurnAround = 0;
        System.out.println("Process\tWaitingTime\tTurnAroundTime");
        for (int id : turnAroundTimeMap.keySet()) {
            int wt = waitingTimeMap.get(id);
            int tat = turnAroundTimeMap.get(id);
            totalWaiting += wt;
            totalTurnAround += tat;
            System.out.println("P" + id + "\t" + wt + "\t\t" + tat);
        }
        int n = turnAroundTimeMap.size();
        System.out.println("Average Waiting Time: " + (double) totalWaiting / n);
        System.out.println("Average Turn-Around Time: " + (double) totalTurnAround / n);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.runScheduling();
    }
}
