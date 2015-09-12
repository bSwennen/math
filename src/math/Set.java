package math;

import java.util.Collection;
import java.util.HashSet;

public class Set extends HashSet<Object> {
	private static final long serialVersionUID = 1L;

	public Set() {
		super();
	}

	public Set(Collection<Object> c) {
		super(c);
	}

	public static Set intersection(Set... sets) {
		Set interS = new Set();

		for (Object o : sets[0].toArray()) {
			int count = 0;
			for (int i = 1; i < sets.length; i++)
				if (sets[i].contains(o))
					count++;
			if (count == sets.length - 1)
				interS.add(o);
		}
		return interS;
	}

	public static Set union(Set... sets) {
		Set union = new Set();
		for (Set set : sets)
			for (Object o : set.toArray())
				union.add(o);
		return union;
	}

	// TODO define this in the other direction?
	public boolean isSubset(Set set) {
		int count = 0;
		for (Object o : set)
			if (this.contains(o))
				count++;

		if (count == set.size())
			return true;

		return false;
	}

	public static void main(String[] args) {
		Set set1 = new Set();
		Set set2 = new Set();
		// set1.add(1);
		// set1.add("r");
		set1.add("test");
		set2.add(7);
		set2.add("r");
		System.out.println(set2.isSubset(set1));
	}
}