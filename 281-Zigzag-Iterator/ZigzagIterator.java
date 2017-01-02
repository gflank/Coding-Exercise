// k iterators
public class ZigzagIterator {
    private Queue<Iterator<Integer>> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) queue.offer(v1.iterator());
        if (!v2.isEmpty()) queue.offer(v2.iterator()); 
    }

    public int next() {
        Iterator<Integer> polled = queue.poll();
        int res = polled.next();
        if (polled.hasNext()) queue.offer(polled);
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */


// two iterators
public class ZigzagIterator {
    private Iterator<Integer> main;
    private Iterator<Integer> alt;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        main = v1.iterator();
        alt = v2.iterator();
    }

    public int next() {
        Iterator<Integer> temp = main;
        main = alt;
        alt = temp;
        return temp.next();
    }

    public boolean hasNext() {
        if (main.hasNext()) return true;
        if (alt.hasNext()) {
            Iterator<Integer> temp = main;
            main = alt;
            alt = temp;
            return true;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */