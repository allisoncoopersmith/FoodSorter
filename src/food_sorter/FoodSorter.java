package food_sorter;

import java.util.ArrayList;
import java.util.Collections;


/*
 *This class accepts different types of foods, sorts them, and then prints them in order
 */
public class FoodSorter {


	/*FOOD can be inherited by particular instantiations of food, and has one member variable:
	 * a size (which is unique to each instantiation of a food)
	 */
	public static abstract class FOOD implements Comparable<FOOD>  {
		private int size;
		public FOOD () {
			this.size = -1;
		}
		public FOOD (int size) {
			this.size = size;
		}

		public int getSize() {
			return this.size;
		}
		public abstract String getName();

		public String toString () {
			return this.getName() + " " + this.getSize();
		}

		public int compareTo (FOOD other) {
			if (this.getSize() < other.getSize()) {
				return -1;
			}
			if (this.getSize() == other.getSize()) {
				return this.getName().compareTo(other.getName());
			}
			return 1;
		}
	}
	/* A Potato is a FOOD
	 * Every Potato's name is "Potato"
	 * Potato has no default size specific to it
	 */
	public static class Potato extends FOOD {
		public Potato () {
		}

		public Potato (int size) {
			super(size);
		}

		public String getName() {
			return "Potato";
		}

	}
	/* A Tomato is a FOOD
	 * Every Tomato's name is "Tomato"
	 * Its default size is 121
	 */
	public static class Tomato extends FOOD {
		public Tomato () {
			super(121);
		}
		public Tomato (int size) {
			super(size);
		}

		public String getName() {
			return "Tomato";
		}

	}

	/*
	 *Prints a list of foods
	 */
	public static void print(ArrayList<FOOD> foods) {
		for (FOOD food : foods) {
			System.out.println(food.toString());
		}
	}

	public static void main(String[] args) {
		ArrayList<FOOD> foods = new ArrayList<FOOD>();

		foods.add(new Tomato(11));
		foods.add(new Tomato());
		foods.add(new Potato(1));
		foods.add(new Potato(42));
		foods.add(new Potato(77));
		foods.add(new Potato(55));
		foods.add(new Potato(46));
		foods.add(new Potato(12));
		foods.add(new Potato(11));
		foods.add(new Potato(9));


		Collections.sort(foods);
		print(foods);
	}
}
