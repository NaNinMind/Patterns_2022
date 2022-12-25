import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) throws Exception {
        Decorator paliSet = new PaliSet(new TreeSet<String>());
        }
}


abstract class Decorator implements Set<String>{
    protected Set<String> setInstance;
    Decorator(Set<String> inst){
        setInstance = inst;
    }
}
class PaliSet extends Decorator{

    PaliSet(Set<String> inst){
        super(inst);
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
    public boolean contains(Object o) {
        return setInstance.contains(o);
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
    public boolean add(String e) {
        return setInstance.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return setInstance.remove(o);
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
    String reverse(String el){
        char ch;
        String elRev = "";
        for (int i=0; i< el.length(); i++)
            {
                ch= el.charAt(i); //extracts each character
                elRev= ch+elRev; //adds each character in front of the existing string
            }
        return elRev;
    }
    
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
    }
}







