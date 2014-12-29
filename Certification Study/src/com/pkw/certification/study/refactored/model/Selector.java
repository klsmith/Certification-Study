package com.pkw.certification.study.refactored.model;

import java.util.List;

public class Selector<E> {

	private List<E> list;
	private int index;

	public Selector(List<E> list) {
		this.list = list;
	}

	public void moveToNext() {
		if (isAtTopBounds()) {
			goToBottom();
		} else {
			goUp();
		}
	}

	private boolean isAtTopBounds() {
		return index >= list.size();
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
	}

	private boolean isAtBottomBounds() {
		return index <= 0;
	}

	private void goToTop() {
		index = list.size();
	}

	private void goDown() {
		index--;
	}

	public E selected() {
		return list.get(index);
	}
}
