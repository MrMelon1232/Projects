package FX_W20PKG;


public class StructureList implements Cloneable {
	
	
	private class StructureNode implements Cloneable{
		
		private Structure sObj;
		private StructureNode next;
		
		public StructureNode() {
			sObj = null;
			next = null;
		}
		
		public StructureNode(Structure a, StructureNode b)
		{
			this.sObj = a;
			this.next = b;
		}
		
		public StructureNode(StructureNode aStrucNode)
		{
			this.sObj = aStrucNode.sObj.clone();
			this.next = aStrucNode.next;
			
		}

		public Structure getObj() {
			return sObj;
		}

		public void setsObj(Structure sObj) {
			this.sObj = sObj;
		}

		public StructureNode getNext() {
			return next;
		}

		public void setNext(StructureNode next) {
			this.next = next;
		}
		
		public StructureNode clone() {
			
			return new StructureNode(this);
		}
		
	}
	
	private StructureNode head;
	
	public StructureList() {
		head = null;
	}
	
	public StructureList(StructureList alist) {
		
		if(alist.head == null)
		{
			head = null;
		}
		
		else
		{
			head = null;
			StructureNode s1 = alist.head;
			StructureNode s2 = null;
			
			while(s1.next != null)
			{
				if(head == null)
				{
					head = new StructureNode(s1);
					s2 = head;
				}
				else
				{
					s2.next = new StructureNode(s1);
					s2 = s2.next;
				}
				s1 = s1.next;
			}
			s2 = null;
		}
		
	}
	
	public void addToStart(Structure struc)
	{
		head = new StructureNode(struc, head);
		
	}
	
	public void addAtEnd(Structure struc)
	{
		StructureNode last = new StructureNode(struc, null);
		last.sObj = struc;
		StructureNode st = head;
		
		if(head == null)
		{
			head = last;
		}
		
		while(st.next != null)
			st = st.next;
		
		st.next = last;
		
	}
	
	public Object clone() {
		
		StructureList copy = new StructureList();
		StructureNode sn = new StructureNode();
		
		if(copy.head == null)
		{
			copy.addToStart(head.getObj());
		}
		
		while(sn.next != null)
		{
			sn = sn.next;
			copy.addAtEnd(sn.getObj());
		}
		
		return copy;
		
	}
	
	public void append(StructureList sl)
	{
		StructureNode tail;
		StructureNode st = head;
		
		
		while (st.next != null)
		{
			st = st.next;
		}
		
		st.setNext(sl.head);
	}
	
	
	
	public void showListContents() {
		
		if(head == null)
		{
			System.out.println("The list is empty!");
		}
		else
		{
			StructureNode sn = head;
			System.out.println("Here are the contents of the list:");
		
			while(sn != null)
			{
				System.out.println(sn.sObj + " ===> X\n");
				sn = sn.next;
			}
		}
	}
	
	
	
	
	

}
