package Concepts;

public class MultiThreading {
	private static int i = 1;
	private int id;
	private Thread t = new Thread(new Runnable() {
		@Override
		public void run() {
			do {
				System.out.println("ThreadId: " + id + " val: " + i++);
			}while(i <= 100);
			
		}
	});
	
	public MultiThreading(int id) {
		this.id = id;
	}
	
	public void start() {
		t.start();
	}

	public static void main(final String[] args) {
		MultiThreading t1 = new MultiThreading(1);
		MultiThreading t2 = new MultiThreading(2);
		t1.start();
		t2.start();
	}
}
