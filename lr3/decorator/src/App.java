import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;




/**** i honestly dont even understand the assignment...  */

public class App {
    public static void main(String[] args) throws Exception {
        Set<String> paliSetReal = new PaliSet(new TreeSet<String>(), true);

        paliSetReal.add("qwe");

        Set<String> paliSetMirror = new PaliSet( new TreeSet<String>(), false);

        paliSetMirror.add("qwe");

        }
}


abstract class Decorator<String> implements Set<String>{
    protected Set<String> setInstance;
    Decorator(Set<String> inst){
        setInstance = inst;
    }
}
class PaliSet<String> extends Decorator<String>{

    boolean real;

    PaliSet(Set<String> inst, boolean real){
        super(inst);
        this.real = real;
    }
    /**********mandatory stuff**************/
    @Override
    public int size() {
        return setInstance.size();
    }

    @Override
    public boolean isEmpty() {
        return setInstance.isEmpty();
    }

    
    @Override
    public Iterator<String> iterator() {
        return setInstance.iterator();
    }

    @Override
    public Object[] toArray() {
        return setInstance.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return setInstance.toArray(a);
    }

    
    @Override
    public boolean containsAll(Collection<?> c) {
        return setInstance.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return setInstance.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return setInstance.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return setInstance.remove(c);
    }
    @Override
    public void clear() {
        setInstance.clear();
    }
    
    /*********** important stuff ************/
    @Override
    public boolean add(Object o) {
        if ( real ){
            return setInstance.add((String)o);
        } else{
            
            return setInstance.add(reverse((String)o));
        }
    }

    @Override
    public boolean remove(Object el) {
        if ( real ){
            return remove((String)el);
        }
        else{
            return remove(reverse((String)el));
        }
    }
    @Override
    public boolean contains(Object o) {
        if (real){
            return contains((String)o);
        }
        else{
            return contains(reverse((String)o));
        }
    }

    String reverse(Object el){
        char ch;
        java.lang.String elRev = "";
        for (int i = 0; i < el.toString().length(); ++i)
            {
                ch = el.toString().charAt(i);
                elRev= ch + elRev.toString(); //adds each character in front of the existing string
            }
        return (String)elRev;
    }
    /*
    public boolean add(String el, boolean real){
        if ( real ){
            return add(el);
        } else{
            return add(reverse(el));
        }
    }
    public boolean contains(String el, boolean real){
        if (real){
            return contains(el);
        }
        else{
            return contains(reverse(el));
        }
    }
    public boolean remove(String el, boolean real){
        if ( real ){
            return remove(el);
        }
        else{
            return remove(reverse(el));
        }
    }*/
}







