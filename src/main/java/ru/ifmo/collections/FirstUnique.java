package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
	private Set<Integer> notUniqueNumbers = new HashSet<>();
	private LinkedHashSet<Integer> uniqueNumbers = new LinkedHashSet<>();

	public FirstUnique(int[] numbers) {
		for (int value : numbers)
			add(value);
	}

	public int showFirstUnique() {
		var iter = uniqueNumbers.iterator();
		if (iter.hasNext())
		    return iter.next();
		else
		    return -1;
	}

	public void add(int value) {
        if (uniqueNumbers.contains(value)) {
            uniqueNumbers.remove(value);
            notUniqueNumbers.add(value);
        }
        else if (!notUniqueNumbers.contains(value)) {
            uniqueNumbers.add(value);
        }
	}
}
