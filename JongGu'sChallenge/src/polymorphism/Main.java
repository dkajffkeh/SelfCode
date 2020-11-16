package polymorphism;

public class Main {

	public static void main(String[] args) {
		
		Worrior w = (Worrior)new Heo("전사");
		
		w.name="??";
		System.out.println(w.name);

	}

}
