package math;

public class TopologicalSpace {
	private Set set;
	private Set topology; // TODO create class topology?

	public TopologicalSpace() {
		set = new Set();
		// trivial topology
		topology = Set.union(new Set(), set);
	}

	public TopologicalSpace(Set s, Set t) {
		isTopology(s, t);
		set = s;
		topology = t;
	}

	private boolean isTopology(Set s, Set t) {
		boolean subsets = false;
		boolean emptyIn = false;
		boolean setIn = false;
		boolean unionIn = false;
		boolean intersIn = false;

		for (Object tO : t)
			if (!(tO instanceof Set))
				return false;

		int count = 0;
		for (Object tO : t)
			if (s.isSubset((Set) tO))
				count++;
		if (count != t.size())
			return false;
		
		if (!t.contains(new Set()))
			return false;

		if (!t.contains(t))
			return false;
		
		return true;
	}
}