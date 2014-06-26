import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;

public class CircularQueue {
	
	private int capacity;
	private int size;
	private Object[] data;
	private int headIndex;
	private int tailIndex;

	public CircularQueue(int capacity) {
		this.capacity = capacity;
		data = new Object[capacity];
		size = 0;
		headIndex = 0;
		tailIndex = -1;
	}
	
	public int size() {
		return size;
	}
	
	public void add(Object arg0) {
		if (size == capacity) {
			data[headIndex] = arg0;
			tailIndex = headIndex;
			headIndex = (headIndex + 1) % capacity;
			if (size < capacity) {
				size++;
			}
		} else {
			tailIndex = (tailIndex + 1) % capacity;
			data[tailIndex] = arg0;
			if (size < capacity) {
				size++;
			}
		}
	}
	
	public void remove() {
		if (size > 0) {
			data[headIndex] = null;
			headIndex = (headIndex + 1) % capacity;
			size--;
		}
	}
	
	public void printQueue() {
		if (size > 0) {
			if (headIndex <= tailIndex) {
				for (int i = headIndex; i < tailIndex + 1; i++) {
					System.out.println(data[i]);
				}
			} else {
				for (int i = headIndex; i < data.length; i++) {
					System.out.println(data[i]);
				}
				for (int j = 0; j < tailIndex + 1; j++) {
					System.out.println(data[j]);
				}
			}
		}
	}
	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String queueSize = in.readLine();
		int x = Integer.parseInt(queueSize);
		CircularQueue c = new CircularQueue(x);
		String temp;
		
		while (true) {
			String next = in.readLine();
			if (next.startsWith("A")) {
				x = Integer.parseInt(next.substring(2));
				while (x > 0) {
					temp = in.readLine();
					c.add(temp);
					x--;
				}
			} else if (next.startsWith("R")) {
				x = Integer.parseInt(next.substring(2));
				while (x > 0) {
					c.remove();
					x--;
				}
			} else if (next.startsWith("L")) {
				c.printQueue();
			} else if (next.startsWith("Q")) {
				return;
			} else {
				//Do nothing
			}
		}
		
		

	}


}
