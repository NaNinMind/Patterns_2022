import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import java.util.Scanner;


class Pair{
    Pair(int f, int s){
        first = f;
        second = s;
    }
    public int first, second;
}

public class App {
    public static void main(String[] args) throws Exception {
        ConcreteObservable obs = new ConcreteObservable();
        obs.run();
    }
}


interface Observable{
    void registerObserver(MyObserver o);
    void removeObserver(MyObserver o);
    void notifyObservers();
}

class ConcreteObservable implements Observable{
    int nextID;
    final int[][] arr = new int[10][10];
    ArrayList observers;
    Scanner in;
    ConcreteObservable(){
        nextID = 0;
        in = new Scanner(System.in);
        printArr(arr);
        observers = new ArrayList<MyObserver>();
    }
    static void printArr(int[][] array){
        System.out.println("---------------------------");
        for ( int[] row : array ){
            for ( int cell : row){
                //cell = 0;
                System.out.print(cell);
            }
            System.out.println();
        }
    }
    void updateState(){
        ArrayList changeArr = new ArrayList<Pair>();
        int cnt = 0;
        System.out.println("--------change-------------");
        for ( int i = 0 ; i < arr.length; ++i){
            int[] row = arr[i];
            String s = in.nextLine();
            for ( int j = 0; j < 10; ++j){
                int tmp = row[j];
                row[j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                if ( tmp != row[j] ){
                    cnt++;
                    changeArr.add(new Pair(i,j));
                }
            }
        }
        if ( cnt > 2){
        notifyObservers(changeArr);
        }
    }
    public void registerObserver(MyObserver o){
        observers.add(o);
    }
    public void removeObserver(MyObserver o){
        observers.remove(o);
    }
    public void notifyObservers(ArrayList<Pair> change){
        for ( int i = 0; i < observers.size(); ++i){
            ((MyObserver)observers.get(i)).update(change);
        }
    }
    void run(){
        while (true){
            System.out.println("Current observers:");
            for ( int i = 0; i < observers.size(); ++i){
                int id = ((MyObserver)observers.get(i)).getID();
                System.out.println(id);
            }
            System.out.println("----------------\n(+) to add observer\n(-) to remove observer\n(=) to change data\n(x) to exit");
            Scanner in = new Scanner(System.in);
            String s = in.next();
            char c = s.charAt(0);
            if ( c == '+'){
                registerObserver(new MyConcreteObserver());

            }
            else if ( c == '-'){
                System.out.print("id to delete:");
                int id = in.nextInt();
                observers.removeIf(obs -> ((MyObserver)obs).getID() == id );
            }else if ( c == '='){
                updateState();
            }else if ( c=='x'){
                in.close();
                return;
            }else{
                System.out.println("err");
            }
        }
    }
}

interface MyObserver{
    void update(ArrayList<Pair> upd);
    int getID();
}

class MyConcreteObserver implements MyObserver{
    static int nextID = 0;
    private int id;
    MyConcreteObserver(){
        id = nextID++;
    }
    public int getID() {
        return id;
    }
    public void update(ArrayList<Pair> upd){
        System.out.println("--------id:"+id+"-------------");
        System.out.println("Movement in:");
        for ( int i = 0; i < upd.size(); ++i){
            System.out.print("("+ upd.get(i).first + ","+upd.get(i).second+")");
            if ( i != upd.size() - 1){
                System.out.print(",");
            }
        }
        System.out.println();
    }
}



