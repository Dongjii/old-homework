/**
 * A class that represents an object that observes and is 
 * informed of changes in observable.
 *
 *@author Dong Luu
 *@version 22 February 2018
 */
public interface MyObserver {
	public void update(MyObservable o, Object arg);

}