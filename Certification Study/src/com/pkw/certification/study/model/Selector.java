package com.pkw.certification.study.model;

import java.util.ArrayList;
import java.util.List;

public class Selector<E> {

	private List<MoveListener> listeners;
	private List<E> list;
	private int index;

	public Selector(List<E> list) {
		this.list = list;
		listeners = new ArrayList<MoveListener>();
	}

	public void moveToNext() {
		if (isAtTopBounds()) {
			goToBottom();
		} else {
			goUp();
		}
		onMove();
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
		onMove();
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

	public void addMoveListener(MoveListener listener) {
		listeners.add(listener);
	}

	private void onMove() {
		for (MoveListener listener : listeners) {
			listener.onMove();
		}
	}

	public static abstract class MoveListener {
		public abstract void onMove();
	}
}
