package sets;

import java.util.Iterator;

public class LinkedSet<E> implements Set<E> {
  private LinkedNode<E> head = null;

  // Constructors
  public LinkedSet() {
	  
  }

  public LinkedSet(E e) {
    this.head = new LinkedNode<E>(e, null);
  }

  private LinkedSet(LinkedNode<E> head) {
    this.head = head;
  }

  @Override
  public int size() {
    // TODO (1)
	  int count = 0;
	  for (E e : this){
		  count+=1;
		  if (count == Integer.MAX_VALUE) count = Integer.MAX_VALUE;
	  }
    return count;
  }

  @Override
  public boolean isEmpty() {
    // TODO (2)
    return !this.iterator().hasNext();
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedNodeIterator<E>(this.head);
  }

  @Override
  public boolean contains(Object o) {
    // TODO (3)
	  //if (o == null) return true;
	  for (E e : this)if (e.equals(o)) return true;
    return false;
  }

  @Override
  public boolean isSubset(Set<E> that) {
    // TODO (4)
	  if (this.isEmpty()) return true;
	  for (E ea : this)if (!that.contains(ea)) return false;
    return true;
  }

  @Override
  public boolean isSuperset(Set<E> that) {
    // TODO (5)
    return that.isSubset(this);
  }

  @Override
  public Set<E> adjoin(E e) {
    // TODO (6)
	  for (E ei : this) if (e.equals(ei)) return this;
	  this.head = new LinkedNode<E>(e, head);
    return this;
  }

  @Override
  public Set<E> union(Set<E> that) {
    // TODO (7)
	  Set<E> ret = this;
	  for (E ea : that)ret.adjoin(ea);
    return ret;
  }

  @Override
  public Set<E> intersect(Set<E> that) {
    // TODO (8)
	  LinkedNode<E> re = null;
	  for (E ei:this)for (E ea: that)if (ei.equals(ea)) re = new LinkedNode<E>(ei, re);
    return new LinkedSet<E>(re);
  }

  @Override
  public Set<E> subtract(Set<E> that) {
    // TODO (9)
	  LinkedNode<E> re = null;
	  for (E ei:this)if (!that.contains(ei)) re = new LinkedNode<E>(ei, re);
    return new LinkedSet<E>(re);
  }

  @Override
  public Set<E> remove(E e) {
    // TODO (10)
	  LinkedNode<E> re = null;
	  for (E ei:this)if (!ei.equals(e)) re = new LinkedNode<E>(ei, re);
	  this.head = re;
    return this;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (! (o instanceof Set)) {
      return false;
    }
    Set<E> that = (Set<E>)o;
    return this.isSubset(that) && that.isSubset(this);
  }

  @Override
    public int hashCode() {
    int result = 0;
    for (E e : this) {
      result += e.hashCode();
    }
    return result;
  }
}
