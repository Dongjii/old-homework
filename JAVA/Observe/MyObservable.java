import java.util.ArrayList;

/**
 * A class that represents an object that can be observed.
 *
 *@author Dong Luu
 *@version 22 Februrary 2018
 */
public class MyObservable {
	boolean changed;
	
	private ArrayList<MyObserver> myObservers = new ArrayList<>();
	
	/**
	 * Adds an observer to the set of observers for this object
	 *
	 *@param o Observer object being added
	 *@throws NullPointerException null observer
	 */
	public void addObserver(MyObserver o) {
		/*if (!myObservers.contains(o)) {
			myObservers.add(o);
		}*/
		if (o == null) {
			throw new NullPointerException("Null observer");
		}
		else {
			myObservers.add(o);
		}
	}
	
	/**
	 * Once all observers are notified, reset changed back to false.
	 */
	protected void clearChanged() {
		changed = false;
	}
	
	/**
	 * Counts and returns the number of observer objects.
	 *
	 *@return number of observers 
	 */
	public int countObservers() {
		return myObservers.size();
	}
	
	/**
	 * Tests if this object has changed.
	 *
	 *@return objects has changed
	 */
	public boolean hasChanged() {
		return changed;
	}
	
	/**
	 * If the object has changed, notify all of its observers and reset its
	 * state using <code>clearChanged</code> method.
	 */
	public void notifyObservers() {
		notifyObservers(null);
	}
	
	/**
	 * If the object has changed, notify all of its observers and reset its
	 * state using <code>clearChanged</code> method.
	 *
	 *@param arg object being updated
	 */
	public void notifyObservers(Object arg) {
		if (hasChanged() == changed) {
			for (int i = 0; i<myObservers.size(); i++) {
				myObservers.get(i).update(this, arg);	
			}
			clearChanged();
		}
		else {};
	}
	
	/**
	 * Marks this observable object as having been changed;
	 * the hasChanged method will now return true;
	 */
	protected void setChanged() {
		changed = true;
	}
}