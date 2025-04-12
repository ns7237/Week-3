class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int size = 0;
    private final int maxSize = 10;

    public void performAction(String newContent) {
        TextState newState = new TextState(newContent);
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }
        if (tail != null) {
            tail.next = newState;
            newState.prev = tail;
        } else {
            head = newState;
        }
        tail = newState;
        current = newState;
        size++;
        if (size > maxSize) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.performAction("Hello");
        editor.performAction("Hello World");
        editor.performAction("Hello World!");
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
        editor.performAction("New Text After Undo");
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
