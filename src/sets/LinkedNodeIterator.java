package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
    // TODO (1) choose appropriate attributes
	LinkedNode<E> first;
	LinkedNode<E> cur;
  
  // Constructors
  public LinkedNodeIterator(LinkedNode<E> head) {
      // TODO (2) choose appropriate parameters and do the initialization
	  this.first = new LinkedNode<E> (null, head);
	  this.cur = first;
  }

  @Override
  public boolean hasNext() {
    // TODO (3)
    return cur.getNext()!=null;
  }

  @Override
  public E next() {
    // TODO (4)
	cur = cur.getNext();
    return cur.getData();
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
