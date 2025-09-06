import java.util.*;

public class CellList {
	
	// (a) an inner class called CellNode
	class CellNode {
		
		// (a)(i) Two private attributes: an object of CellPhone and a pointer to a CellNode object;
		private CellPhone cp;
		private CellNode next;
		
		// (a)(ii) A default constructor, which assigns both attributes to null; 
		public CellNode() {
			cp = null;
			next = null;
		}
		
		// (a)(iii) A parameterized constructor that accepts two parameters, 
		//a CellPhone object and a CellNode object, then initializes the attributes accordingly;  
		public CellNode(CellPhone cp1, CellNode next1) {
			cp = cp1;
			next = next1;
		}
		
		// (a)(iv) A copy constructor; 
		public CellNode(CellNode x) {
			cp = x.cp;
			next = x.next;
		}
		
		// (a)(v) A clone() method; 
		public CellNode clone() {
			try {
				CellNode wasCloned = (CellNode) super.clone();
				return wasCloned;
			}
			catch(CloneNotSupportedException e) {
				System.out.println("This clone is not supported");
				return null;
			}
		}
		
		// (a)(vi) Other mutator and accessor methods. 
		public void setCellPhone(CellPhone cp1) {
			cp = cp1;
		}
		
		public CellPhone getCellPhone() {
			return cp;
		}
		
		public void setCellNode(CellNode next1) {
			next = next1;
		}
		
		public CellNode getCellNode() {
			return next;
		}
		
	}
	
	// (b) A private attribute called head, which should point to the first node in this list object; 
	private CellNode head;
	
	// (c) A private attribute called size, which always indicates the current size of the list (how many nodes are in the list); 
	private int size;
	
	// (d) A default constructor, which creates an empty list; 
	public CellList() {
		head = null;
		size = 0;
	}
	
	// (e) A copy constructor, which accepts a CellList object and creates a copy of it; 
	public CellList(CellList cl) {
		if(cl.head == null) {
			// If the original list is empty, make the new list empty too.
			head = null;
		}
		else {
			// Copy the first node 
			head = new CellNode(cl.head.cp, null);
			
			// Create a pointer to traverse the new list
			CellNode t2 = head;
			
			// Create a pointer to traverse the original list
			CellNode t1 = cl.head.next;
			
			// Loop through original list
			while(t1 != null) {
				t2.next = new CellNode(t1.cp, null); // Copy the data into a new node
				t2 = t2.next; // Move to the next node in the new list
				if(t1.next != null) {
					t1 = t1.next; // Move to the next node in the original list
				}
				else {
					break;
				}
			}
		}
		
	}
	
	// (f) A method called addToStart(), which accepts one parameter, an object from CellPhone class. 
	// The method then creates a node with that passed object and inserts this node at the head of the list;
	public void addToStart(CellPhone cp) {
		head = new CellNode(cp, head);
		size++;
	}
	
	// (g) A method called insertAtIndex(), which accepts two parameters, an object from CellPhone class, and an integer representing an index. 
	public void insertAtIndex(CellPhone cp, int z) {
		if(z < 0 || z > (size-1)) {
			throw new NoSuchElementException("Invalid index: " + z);
		}
		// Special case: Insert at the beginning
		if(z == 0) {
			head = new CellNode(cp, head);
		}
		else {
			// Traverse to the node just before the wanted index
			CellNode t = head;
			for(int i = 0 ; i < (z-1) ; i++) {
				t = t.next;
			}
			t.next = new CellNode(cp, t.next);
		}
		// Increment the size of the linked list
		size++;
	}
	
	// (h) A method called deleteFromIndex(), which accepts one integer parameter representing an index
	public void deleteFromIndex(int z) {
		if(z < 0 || z > (size-1)) {
			throw new NoSuchElementException("Invalid index: " + z);
		}
		// Special case: Delete the head node
		if(z == 0) {
			head = head.next;
		}
		else {
			// Traverse to the node just before the target index
			CellNode t = head;
			for(int i = 0 ; i < (z-1) ; i++) {
				t = t.next;
			}
			t.next = t.next.next;
		}
		// Decrement the size of the linked list
        size--;
	}
	
	// (i) A method called deleteFromStart(), which deletes the first node in the list (the one pointed by head).
	public void deleteFromStart() {
		// Special case: List is empty
        if (head == null) {
            throw new NoSuchElementException("List is empty. Cannot delete from start.");
        }
        // Update head to the next node
        head = head.next;
        // Decrement the size of the linked list
        size--;
	}
	
	// (j) A method called replaceAtIndex(), which accepts two parameters, an object from CellPhone class, and an integer representing an index.
	public void replacAtIndex(CellPhone cp, int z) {
		if(z < 0 || z > (size-1)) {
			return;
		}
		CellNode t = head;
		for(int i = 0 ; i < z ; i++) {
			t = t.next;
		}
		t.cp = cp;
	}
	
	// (k) A method called find(), which accepts one parameter of type long representing a Serial Number.
	// Warning: This method can result in a privacy leak.
	// Reason: toString from the CellPhone class is printing sensitive data (Serial Number)
	// Since the serial number is unique to each CellPhone, it is sensitive and should not be displayed in the console output
	public CellNode find(long aSN) {
		CellNode t = head;
		int iterations = 0;
		// Traverse the list
		while(t != null) {
			iterations++;
			if(t.cp.getSerialNum() == aSN) {
				System.out.println("Phone found after " + iterations + " iterations.");
				System.out.println(t.cp); // Potential privacy leak here
				return t;
			}
			t = t.next;
		}
		// If no match is found, output the number of iterations and return null
        System.out.println("Phone not found after " + iterations + " iterations.");
        return null;
	}
	
	// (l) A method called contains(), which accepts one parameter of type long representing a serial number. 
    public boolean contains(long serialNumber) {
        CellNode t = head;
        // Traverse the list
        while (t != null) {
            if (t.cp.getSerialNum() == serialNumber) {
                return true; 
            }
            t = t.next;
        }
        // Serial number not found
        return false;
    }
    
    // (m) A method called showContents(), which displays the contents of the list. 
    // Warning: This method can result in a privacy leak.
    // Reason: toString from the CellPhone class is used to show all phone details, including the Serial Number
    // Since the serial number is unique to each CellPhone, it is sensitive and should not be displayed in the console output
    public void showContents() {
    	System.out.println();
        System.out.println("The current size of the list is " + size + ".");
        System.out.println("Here are the contents of the list:");
        System.out.println("================================================================");

        CellNode t = head;
        while (t != null) {
            System.out.print(t.cp + " ---> ");
            t = t.next;
        }
        System.out.println("X"); 
    }
    
    // (n) A method called equals(), which accepts one parameter of type CellList. 
    // The method returns true if the two lists contain similar objects;
    public boolean equals(CellList cl) {
    	if (this.size != cl.size) {
            return false;
    	}
    	
    	CellNode t1 = this.head;
    	CellNode t2 = cl.head;
    	// Traverse both lists
        while (t1 != null && t2 != null) {
            if (!t1.cp.equals(t2.cp)) {
                return false; 
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return true; // All elements matched
    }

}
