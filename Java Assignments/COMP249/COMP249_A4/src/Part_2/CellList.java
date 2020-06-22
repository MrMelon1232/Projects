// -----------------------------------------------------
// Assignment 4
// Question: Part 2
// Written by: Julien Phan, ID:40133814
// -----------------------------------------------------

package Part_2;
import java.util.NoSuchElementException;

/**
 * 
 * @author julienphan
 *
 */

//CellList class
public class CellList implements Cloneable {
	
	/**
	 * 
	 * @author julienphan
	 *
	 */
	
	//ClassNode class
	private class CellNode implements Cloneable{
		
		//Variables
		private CellPhone aCellphone;
		private CellNode nextNode;
		
		//Default Constructor
		public CellNode() {
			
			aCellphone = null;
			nextNode = null;
		}
	
		/**
		 * 
		 * @param one
		 * @param two
		 */
		
		//Param Constructor
		public CellNode(CellPhone one, CellNode two) {
			
			this.aCellphone = one;
			this.nextNode = two;
		}
		
		/**
		 * 
		 * @param aCellNode
		 */
		
		//Copy Constructor
		public CellNode(CellNode aCellNode) {
			
			this.aCellphone = aCellNode.aCellphone.clone();
			this.nextNode = aCellNode.nextNode;
		}
		
		/**
		 * 
		 * @return
		 */
		
		//Setters and Getters
		public CellPhone getACellphone() {
			return aCellphone;
		}
		
		/**
		 * 
		 * @param aCellphone
		 */
		public void setACellPhone(CellPhone aCellphone) {
			
			this.aCellphone = aCellphone;
		}
		
		/**
		 * 
		 * @return
		 */
		public CellNode getNextNode() {
			
			return nextNode;
		}
		
		/**
		 * 
		 * @param oneCellNode
		 */
		public void setNextNode(CellNode oneCellNode) {
			
			this.nextNode = oneCellNode;

		}
		
		//Clone method
		public CellNode clone() {
			
			return new CellNode(this);
		}
		
	}
	
	//Variables
	private CellNode head;
	private int size;
	
	//Default Constructor
	public CellList() {
		
		head = null;
		size = 0;
		
	}
	
	/**
	 * 
	 * @param aCellList
	 */
	
	//Copy Constructor
	public CellList(CellList aCellList) {
		
		size = aCellList.size;
		
		if(aCellList.head == null)
		{
			head = null;
		}
		else
		{
			head = null;
			CellNode c1 = aCellList.head;
			CellNode c2 = null;
			
			while(c1 != null)
			{
				if(head == null)
				{
					head = new CellNode(c1);
					c2 = head;
				}
				else
				{
					c2.nextNode = new CellNode(c1);
					c2 = c2.nextNode;
				}
				c1 = c1.nextNode;
			}
			c2 = null;
		}
	}
	
	/**
	 * 
	 * @param aCellPhone
	 */
	
	//addToStart method
	public void addToStart(CellPhone aCellPhone) {
		
		head = new CellNode(aCellPhone,head);
		size++;
		
	}
	
	/**
	 * 
	 * @param cell
	 * @param index
	 */
	
	//InsertAtIndex method
	public void insertAtIndex(CellPhone cell, int index) {
		
		try {
			
			if(index < 0 || index > (this.size-1))
				throw new NoSuchElementException("Out of the bound of the current list!");
			
			if(index ==0)
				addToStart(cell);
			else
			{
				CellNode node = head;
				
				for(int i =0; i < (index-1); i++)
				{
					node = node.nextNode;
				}
				node.nextNode = new CellNode(cell, node.nextNode);
			}
		}catch(NoSuchElementException e) {
			
			System.out.println(e.getMessage());
			System.out.println("No info inserted!!");
		}
	}
	
	/**
	 * 
	 * @param index
	 */
	
	//DeleteFromIndex
	public void deleteFromIndex(int index) {
		
		try {
			if(index < 0 || index > (this.size-1))
				throw new NoSuchElementException("Out of bound of the current list!");
			
			if(index == 0)
				deleteFromStart();
			else
			{
				CellNode cell = head;
			
				for(int i =0;i < (index-1); i++)
				{
					cell = cell.nextNode;
				}
				cell.nextNode = cell.nextNode.nextNode;
				cell = null;
				size--;
			}
			}catch(NoSuchElementException e)
				{
					System.out.println(e.getMessage());
					System.out.println("No info has been deleted!");
				}
	
	}
	
	//DeleteFromStart
	public void deleteFromStart() {
		
		if(head == null)
			return;
		head = head.nextNode;
		size--;
	}

	/**
	 * 
	 * @param cell
	 * @param index
	 */
	
	//ReplaceAtIndex
	public void replaceAtIndex(CellPhone cell, int index)
	{
		if(index < 0 || index > (this.size-1))
			return;
		if(head == null)
			return;
		else
		{
			CellNode node = head;
			for(int i = 0 ; i < index; i++)
			{
				node = node.nextNode;
			}
			node.aCellphone = cell;
		}
	}
	
	/**
	 * 
	 * @param serialNum
	 * @return
	 */
	
	//Find method
	public CellNode find(long serialNum) {
		
		int index = 0;
		
		if(head == null)
		{
			index++;
			return null;
		}
		else
		{
			CellNode node = head;
			
			while(node != null && node.aCellphone.getSerialNum() != serialNum)
			{
				node = node.nextNode;
				index++;
			}
			System.out.println("The number of iteration done is " + index);
			
			if(node == null)
			{
				return null;
			}
			else
			{
				return node;
			}
		}
	}
	
	/**
	 * 
	 * @param serialNum
	 * @return
	 */
	
	//Contains method
	public boolean contains(long serialNum) {
		
		if(find(serialNum) == null)
		{
			System.out.println("No cell phone with that serial number could be found!");
			return false;
		}
		else
		{
			System.out.println("Cell phone found!!, here is the information!");
			System.out.println(find(serialNum).aCellphone);
			return true;
		}
	}
	
	//ShowContents method
	public void showContents() {
		
		if(head == null)
		{
			System.out.println("The list is empty!!");
		}
		else
		{
			CellNode node = head;
			 System.out.println("The current size of the list is "+size+". Here are the contents of the list:");
	         System.out.println("==============================================================================");
	         
	         while(node != null)
	         {
	        	 System.out.println(node.aCellphone + "-->");
	        	 node = node.nextNode;
	         }
		}
	}
	
	/**
	 * 
	 * @param aCellList
	 * @return
	 */
	
	//Equals method
	public boolean equals(CellList aCellList) {
		
		if(this == null || aCellList == null)
		{
			return false;
		}
		
		if(this.size != aCellList.size)
		{
			return false;
		}
		
		else
		{
			CellNode n1 = this.head;
			CellNode n2 = aCellList.head;
			while(n1 != null && n2 != null)
			{
				if(n1.aCellphone.equals(n2.aCellphone))
				{
					n1 = n1.nextNode;
					n2 = n2.nextNode;
				}
				else
				{
					return false;
				}
			}
			return true;
		}
	}
	
}
