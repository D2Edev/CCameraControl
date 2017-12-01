package io.github.d2edev.ccc.models;

import java.util.ArrayList;
import java.util.List;

public class Pair<T> {

	private T t1;
	private T t2;

	public Pair() {
	}

	public Pair(T t1, T t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public T getT1() {
		return t1;
	}

	public T getT2() {
		return t2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((t1 == null) ? 0 : t1.hashCode());
		result = prime * result + ((t2 == null) ? 0 : t2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (t1 == null) {
			if (other.t1 != null)
				return false;
		} else if (!t1.equals(other.t1))
			return false;
		if (t2 == null) {
			if (other.t2 != null)
				return false;
		} else if (!t2.equals(other.t2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[first: ");
		builder.append(t1);
		builder.append(", second: ");
		builder.append(t2);
		builder.append("]");
		return builder.toString();
	}

	public static <T> Pair<T> from(T t1, T t2) {

		return new Pair<T>(t1, t2);
	}

	public static <T> List<T> asList(Pair<T> pair) {
		if (pair == null)
			return null;
		List<T> list = new ArrayList<>();
		list.add(pair.t1);
		list.add(pair.t2);
		return list;
	}

	public static <T> Pair<T> fromList(List<T> list) {
		if (list == null)
			return null;
		if (list.isEmpty())
			return new Pair<>();
		if (list.size() == 1)
			return new Pair<>(list.get(0), null);
		return new Pair<T>(list.get(0), list.get(1));
	}

}
