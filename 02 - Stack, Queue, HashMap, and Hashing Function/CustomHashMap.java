public class CustomHashMap {
    static class Entry {
        int key;
        int value;
        Entry next;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 100;
    private Entry[] table;

    public CustomHashMap() {
        table = new Entry[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Entry head = table[index];
        while (head != null) {
            if (head.key == key) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        Entry newEntry = new Entry(key, value);
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public int get(int key) {
        int index = hash(key);
        Entry head = table[index];
        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Entry head = table[index];
        Entry prev = null;
        while (head != null) {
            if (head.key == key) {
                if (prev == null) table[index] = head.next;
                else prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 100);
        map.put(2, 200);
        map.put(102, 300);

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(102));

        map.remove(2);
        System.out.println(map.get(2));
    }
}
