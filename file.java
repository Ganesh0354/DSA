
package queue;

import java.util.LinkedList;
import java.util.Queue;

public class File {
	private String name;
	private int pages;

	protected File(String name, int pages) {
		super();
		this.name = name;
		this.pages = pages;
	}

	public String getName() {
		return name;
	}

	public int getPages() {
		return pages;
	}

}

class PrintFile {
	private Queue<File> queue = new LinkedList<File>();

	public void addFile(File file) {
		queue.add(file);
		System.out.println(file.getName() + " is added to queue");
	}

	public void processPrinting() {
		while (!queue.isEmpty()) {
			File file = queue.poll();
			System.out.println(file.getName() + " is in process");

			try {
				Thread.sleep(file.getPages() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(file.getName() + " is completed");
		}
		System.out.println("All files are printed");
	}

}
 class MainClass {
	public static void main(String[] args) {
		PrintFile p1 = new PrintFile();
		p1.addFile(new File("Doc1", 3));
		p1.addFile(new File("Doc2", 8));
		p1.addFile(new File("Doc3", 2));
		p1.addFile(new File("Doc4", 5));

		p1.processPrinting();
	}
}
