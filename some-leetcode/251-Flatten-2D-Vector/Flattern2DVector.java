// iterator version
public class Vector2D {
    private Iterator<List<Integer>> iterList;
    private Iterator<Integer> iterEle;

    public Vector2D(List<List<Integer>> vec2d) {
        iterList = vec2d.iterator();
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        return iterEle.next();
    }

    public boolean hasNext() {
        // while iterEle has no next or for the first step
        while ((iterEle == null || !iterEle.hasNext()) && iterList.hasNext()) {
            iterEle = iterList.next().iterator();
        }
        return iterEle != null && iterEle.hasNext();
    }
}


// improved version, without iterator
public class Vector2D {
    private int x, y;
    private List<List<Integer>> vec;
    private boolean seeked;

    public Vector2D(List<List<Integer>> vec2d) {
        vec = vec2d;
        x = 0;
        y = 0;
        seeked = false;
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        seeked = false;
        return vec.get(x).get(y++);
    }

    public boolean hasNext() {
        if (seeked) {
            return y != -1;
        }
        seeked = true;
        while (x < vec.size()) {
            if (y < vec.get(x).size()) {
                return true;
            }
            y = 0;
            ++x;
        }
        y = -1;
        return false;
    }
}


// first accepted version, not neat
public class Vector2D {
    private List<List<Integer>> vec;
    private int x;
    private int y;
    private boolean seeked;

    public Vector2D(List<List<Integer>> vec2d) {
        vec = vec2d;
        // empty list case
        if (vec.size() == 0) {
            seeked = true;
            y = -1;
        }
        else {
            // seek for next valid x and y
            x = 0;
            y = -1;
            seekNext();
        }
    }

    public int next() {
    	if (!hasNext()) {
    		return -1;
    	}
        seeked = false;
        return vec.get(x).get(y);
    }

    public boolean hasNext() {
        if (!seeked) {
            seekNext();
        }
        if (y == -1) {
            return false;
        }
        return true;
    }
    
    private void seekNext() {
        seeked = true;
        y++;
        // make sure x and y are valid
        // if next line
        if (y == vec.get(x).size()) {
            y = 0;
            x++;
            // skip empty line
            while (x < vec.size() && vec.get(x).size() == 0) {
                x++;
            }
            // if skip all lines, set flag
            if (x == vec.size()) {
                y = -1;
            }
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */