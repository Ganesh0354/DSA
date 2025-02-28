package queue;

public class queue {
    int[] queue;
    int topofqueue;
    int biginofqueue;
    
    public queue(int size)
    {
    	queue=new int[size];
    	topofqueue=biginofqueue=-1;
    	System.out.println("the queue is created with size"+ size);
    }
    
    public boolean isfull() {
    	return topofqueue==queue.length-1;
    }
    
    public boolean isempty()
    {
    	return(biginofqueue==-1||biginofqueue==queue.length);
    }
    
    public void enqueue(int value)
    {
    	if(isfull())
    	{
    		System.out.println("the queue is full");
    	}
    	else if(biginofqueue==-1)
    	{
    		biginofqueue=0;
    		topofqueue++;
    		queue[topofqueue]=value;
    		System.out.println("the value"+value+"is inserted");
    	}
    	else
    	{
    		topofqueue++;
    		queue[topofqueue]=value;
    		System.out.println("the value"+value+"is inserted");
    	}
    }
    
    public int dequeue() {
    	if(!isempty())
    	{
    		int value=queue[biginofqueue];
    		biginofqueue++;
    		if(biginofqueue>topofqueue)
    		{
    			biginofqueue=topofqueue=-1;
    		}
    		return value;
    	} 
    	else
    	{
    		System.out.println("the queue is empty");
    		return-1;
    	}
    }
    
    public int peek() {
    	if(isempty())
    	{
    		System.out.println("the queue is empty");
    		return-1;
    	}
    	else
    	{
    		return queue[biginofqueue];
    	}
    }
    
    public void delete() {
    	queue=null;
    	System.out.println("the queue is deleted");
    }
    public static void main(String[] args)
    {
    	queue q=new queue(4);
    	q.isfull();
    	q.isempty();
    	q.enqueue(10);
    	q.enqueue(20);
    	q.enqueue(30);
    	q.enqueue(40);
    	q.dequeue();
    	q.peek();
    	q.delete();
    }
}
