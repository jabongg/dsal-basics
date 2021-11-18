package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.example.datastructures.PrintUtil;

public class ForeachDemo {
	public ForeachDemo() {
	}

	public static void main(String[] args) {
		// Get the stream
		//Stream<String> stream = Stream.of("Geeks", "For", "Geeks", "A", "Computer", "Portal");

		//stream.filter(w -> w.charAt(0) == 'F').forEach(w -> System.out.print(w));

		int[] a = new int[] {1, 3, 4, 5};
		//PrintUtil.printArray(a);
		//PrintUtil.printArray(new int[] {1, 3, 4, 5});

		//System.out.println(ForeachDemo::new);
		streamsDemo();
	}

	public static void streamsDemo() {
		Stream<String> stream = Stream.of("Geeks", "For", "Geeks", "A", "Computer", "Portal");

		// Print the stream
		//stream.forEach(s -> System.out.println(s));
		stream.forEach(System.out::println);
		
		class Widget {

			private String color;
			private Integer weight;

			public Widget(String color, Integer weight) {
				super();
				this.color = color;
				this.weight = weight;
			}

			public String getColor() {
				return color;
			}

			public void setColor(String color) {
				this.color = color;
			}

			public Integer getWeight() {
				return weight;
			}

			public void setWeight(Integer weight) {
				this.weight = weight;
			}

		}
		Widget widget1 = new Widget("RED", 30);
		Widget widget2 = new Widget("WHITE", 35);
		Widget widget3 = new Widget("RED", 40);
		Widget widget4 = new Widget("YELLOW", 70);
		Widget widget5 = new Widget("RED", 60);

		List<Widget> widgets = new ArrayList<>();
		widgets.add(widget1);
		widgets.add(widget2);
		widgets.add(widget3);
		widgets.add(widget4);
		widgets.add(widget5);

		widgets.stream().filter(w -> w.getColor() == "RED").filter(w -> w.getWeight() > 30)
				.forEach(w -> System.out.print("\n" + w.getColor() + " " + w.getWeight()));
		
		widgets.stream().filter(w -> w.getColor() == "YELLOW").filter(w -> w.getWeight() > 30)
		.forEach(w -> System.out.print("\n" + w.getColor() + " " + w.getWeight()));

		
	}
}
