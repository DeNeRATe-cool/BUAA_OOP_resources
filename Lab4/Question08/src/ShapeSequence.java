public class ShapeSequence {
    int top = 0;
    private Shape[] shapes;

    ShapeSequence(int size) {
        if(size < 0) size = 0;
        shapes = new Shape[size];
    }

    public void add(Shape shape) {
        if(shapes.length == top) return;
        shapes[top++] = shape;
    }

    interface Iterator {
        boolean isEnd();
        void moveNext();
        Shape current();
        boolean equals(Object o);
    }

    public SequenceIterator iterator() {
        return new SequenceIterator();
    }

    private class SequenceIterator implements Iterator {
        int id = 0;

        public boolean isEnd() {
            return id == top;
        }

        public void moveNext() {
            if(isEnd()) return;
            id++;
        }

        public Shape current() {
            if(isEnd()) return null;
            return shapes[id];
        }

        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            SequenceIterator that = (SequenceIterator) o;
            return id == that.id;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for(int i = 0; i < top; i++) {
            sb.append(shapes[i].toString()).append(",");
        }
        return sb + "]";
    }
}
