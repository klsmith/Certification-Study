package com.pkw.certification.study.model;

import java.util.ArrayList;
import java.util.List;

public class Selector<E> {

	private List<OnSelectListener> listeners;
	private List<E> list;
	private int index;

	public Selector(List<E> list) {
		this.list = list;
		listeners = new ArrayList<OnSelectListener>();
	}

	public void moveToNext() {
		if (isAtTopBounds()) {
			goToBottom();
		} else {
			goUp();
		}
		onSelect();
	}

	private boolean isAtTopBounds() {
		return index >= list.size() - 1;
	}

	private void goToBottom() {
		index = 0;
	}

	private void goUp() {
		index++;
	}

	public void moveToPrevious() {
		if (isAtBottomBounds()) {
			goToTop();
		} else {
			goDown();
		}
		onSelect();
	}

	private boolean isAtBottomBounds() {
		return index <= 0;
	}

	private void goToTop() {
		index = list.size() - 1;
	}

	private void goDown() {
		index--;
	}

	public E selected() {
		return list.get(index);
	}

	public List<E> list() {
		return list;
	}

	public void addOnSelectListener(OnSelectListener listener) {
		listeners.add(listener);
	}

	private void onSelect() {
		for (OnSelectListener listener : listeners) {
			listener.onSelect();
		}
	}

	public static abstract class OnSelectListener {
		public abstract void onSelect();
	}

}
