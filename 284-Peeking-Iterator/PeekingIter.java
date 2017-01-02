// concise version
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    if (iter.hasNext()) {
	        next = iter.next();
	    }
	    else {
	        next = null;
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = next;
	    if (iter.hasNext()) {
	        next = iter.next();
	    }
	    else {
	        next = null;
	    }
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}


/*------------------------------------------------------------------*/

// Integer version
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> curIter;
    private Integer peekedElement;
    private boolean peeked;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    curIter = iterator;
	    peekedElement = null;
	    peeked = false;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!peeked) {
            peeked = true;
            if (curIter.hasNext()) {
                peekedElement = curIter.next();
            }
            else {
                peekedElement = null;
            }
        }
        return peekedElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peeked) {
	        peeked = false;
	        return peekedElement;
	    }
	    else {
	        return curIter.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    if (peeked) {
	        return peekedElement != null;
	    }
	    else {
	        return curIter.hasNext();
	    }
	}
}


/*------------------------------------------------------------*/

// first accepted version
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> curIter;
    private int peekedVal;
    private boolean peeked;
    private boolean hasNext;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    curIter = iterator;
	    peekedVal = 0;
	    peeked = false;
	    hasNext = true;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!peeked) {
            peeked = true;
            if (curIter.hasNext()) {
                peekedVal = curIter.next();
                hasNext = true;
            }
            else {
                hasNext = false;
            }
        }
        return peekedVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peeked) {
	        peeked = false;
	        return peekedVal;
	    }
	    else {
	        return curIter.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    if (peeked) {
	        return hasNext;
	    }
	    else {
	        return curIter.hasNext();
	    }
	}
}

