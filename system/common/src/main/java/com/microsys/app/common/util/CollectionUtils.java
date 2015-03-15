package com.microsys.app.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.hibernate.service.spi.ServiceException;

public abstract class CollectionUtils {

	public static boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.size() == 0;
	}

	public static boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}

	public static <T> T first(Collection<T> collection) {
		if (isNotEmpty(collection)) {
			return collection.iterator().next();
		}
		return null;
	}

	public static <T> T at(Collection<T> collection, int index) {
		int count = 0;
		if (isNotEmpty(collection)) {
			for (T t : collection) {
				if (count == index) {
					return t;
				}
				count++;
			}
		}
		return null;
	}

	public static <T> T find(Collection<T> collection, IMatcher<T> matcher) {
		if (isNotEmpty(collection)) {
			final Iterator<T> iterator = collection.iterator();
			while (iterator.hasNext()) {
				T t = iterator.next();
				if (matcher.match(t)) {
					return t;
				}
			}
		}
		return null;
	}

	public static <T> boolean contain(Collection<T> collection, IMatcher<T> matcher) {
		if (isNotEmpty(collection)) {
			final Iterator<T> iterator = collection.iterator();
			while (iterator.hasNext()) {
				T t = iterator.next();
				if (matcher.match(t)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static <T> Collection<T> select(Collection<T> collection, IMatcher<T> matcher) {
		final Collection<T> select = new ArrayList<T>();
		if (isNotEmpty(collection)) {
			final Iterator<T> iterator = collection.iterator();
			while (iterator.hasNext()) {
				T t = iterator.next();
				if (matcher.match(t)) {
					select.add(t);
				}
			}
		}
		return select;
	}

	public static <T> void forEach(Collection<T> collection, IClosure<T> closure) throws ServiceException {
		if (CollectionUtils.isNotEmpty(collection)) {
			final Iterator<T> iterator = collection.iterator();
			while (iterator.hasNext()) {
				T t = iterator.next();
				closure.call(t);
			}
		}
	}

	public static <T> List<T> asList(T t) {
		final List<T> list = new ArrayList<T>();
		list.add(t);
		return list;
	}

	public static <T> List<T> sort(List<T> collection, Comparator<T> comparator) {
		return sort(collection, comparator, true);
	}

	public static <T> List<T> sort(List<T> collection, Comparator<T> comparator, boolean assending) {
		if (isNotEmpty(collection)) {
			Collections.sort((List<T>) collection, comparator);
			if (!assending) {
				Collections.reverse(collection);
			}
		}
		return collection;
	}

	public static <T> boolean exist(T t, Object... ts) {
		return Arrays.asList(ts).contains(t);

	}

	public static <T> List<List<T>> parts(final List<T> ls, final int numberOfParts) {
		final List<List<T>> lsParts = new ArrayList<List<T>>();
		final int partSize = ls.size() / numberOfParts;
		int leftOver = ls.size() % numberOfParts;
		int take = partSize;
		for (int toAdd = 0, lsSize = ls.size(); toAdd < lsSize; toAdd += take) {
			if (leftOver > 0) {
				leftOver--;
				take = partSize + 1;
			}
			else {
				take = partSize;
			}
			lsParts.add(new ArrayList<T>(ls.subList(toAdd, Math.min(lsSize, toAdd + take))));
		}
		return lsParts;

	}
}
