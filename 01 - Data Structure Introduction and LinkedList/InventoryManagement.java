class InventoryItem {
    String itemName;
    int itemId;
    int quantity;
    double price;
    InventoryItem next;
    public InventoryItem(String itemName,int itemId,int quantity,double price) {
        this.itemName=itemName;
        this.itemId=itemId;
        this.quantity=quantity;
        this.price=price;
        this.next=null;
    }
}
class InventoryList {
    private InventoryItem head;
    public void addItem(String itemName,int itemId,int quantity,double price) {
        InventoryItem newItem=new InventoryItem(itemName,itemId,quantity,price);
        if(head==null) {
            head=newItem;
            return;
        }
        InventoryItem temp=head;
        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newItem;
    }
    private InventoryItem getMiddle(InventoryItem node) {
        if(node==null||node.next==null) return node;
        InventoryItem slow=node,fast=node.next;
        while(fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private InventoryItem mergeByName(InventoryItem left,InventoryItem right) {
        if(left==null) return right;
        if(right==null) return left;
        if(left.itemName.compareToIgnoreCase(right.itemName)<=0) {
            left.next=mergeByName(left.next,right);
            return left;
        } else {
            right.next=mergeByName(left,right.next);
            return right;
        }
    }
    private InventoryItem mergeSortByName(InventoryItem node) {
        if(node==null||node.next==null) return node;
        InventoryItem mid=getMiddle(node);
        InventoryItem nextToMid=mid.next;
        mid.next=null;
        InventoryItem left=mergeSortByName(node);
        InventoryItem right=mergeSortByName(nextToMid);
        return mergeByName(left,right);
    }
    public void sortByName() {
        head=mergeSortByName(head);
    }
    public void display() {
        InventoryItem temp=head;
        while(temp!=null) {
            System.out.println(temp.itemId+" "+temp.itemName+" "+temp.quantity+" "+temp.price);
            temp=temp.next;
        }
    }
}
public class InventoryManagement {
    public static void main(String[] args) {
        InventoryList inv=new InventoryList();
        inv.addItem("Phone",2,10,500.0);
        inv.addItem("Laptop",1,5,1000.0);
        inv.addItem("Tablet",3,8,300.0);
        inv.addItem("Monitor",4,3,200.0);
        System.out.println("Before Sorting:");
        inv.display();
        inv.sortByName();
        System.out.println("After Sorting:");
        inv.display();
    }
}

