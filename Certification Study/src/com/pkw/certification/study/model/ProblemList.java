package com.pkw.certification.study.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProblemList implements List<Problem> {

	private List<Problem> list;

	public static ProblemList create() {
		return new ProblemList();
	}

	private ProblemList() {
		list = new ArrayList<Problem>();
	}

	@Override
	public boolean add(Problem problem) {
		boolean hasChanged = list.add(problem);
		sort();
		return hasChanged;
	}

	@Override
	public void add(int index, Problem problem) {
		add(problem);
	}

	private void sort() {
		Collections.sort(list);
	}

	public Problem get(int index) {
		return list.get(index);
	}

	@Override
	public boolean addAll(Collection<? extends Problem> collection) {
		boolean hasChanged = false;
		for (Problem problem : collection) {
			if (add(problem)) {
				hasChanged = true;
			}
		}
		return hasChanged;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Problem> collection) {
		return addAll(collection);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean contains(Object obj) {
		return list.contains(obj);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return list.containsAll(collection);
	}

	@Override
	public int indexOf(Object obj) {
		return list.indexOf(obj);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<Problem> iterator() {
		return list.iterator();
	}

	@Override
	public int lastIndexOf(Object obj) {
		return list.lastIndexOf(obj);
	}

	@Override
	public ListIterator<Problem> listIterator() {
		return list.listIterator();
	}

	@Override
	public ListIterator<Problem> listIterator(int index) {
		return list.listIterator(index);
	}

	@Override
	public boolean remove(Object obj) {
		return list.remove(obj);
	}

	@Override
	public Problem remove(int index) {
		return list.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return list.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return list.retainAll(collection);
	}

	@Override
	public Problem set(int index, Problem problem) {
		Problem previous = list.set(index, problem);
		sort();
		return previous;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public List<Problem> subList(int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] array) {
		return list.toArray(array);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (obj instanceof ProblemList) {
			ProblemList other = (ProblemList) obj;
			if (size() != other.size()) {
				return false;
			}
			for (int i = 0; i < size(); i++) {
				if (!get(i).equals(other.get(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String result = "ProblemList {\n";
		for (Problem problem : list) {
			result += problem.toString() + "\n";
		}
		result += "}";
		return result;
	}

	public Selector<Problem> selector() {
		return new Selector<Problem>(this);
	}
}
