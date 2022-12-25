public class App {
    public static void main(String[] args) throws Exception {
        
        String[] u1R = {"qwe","123","admin"};
        String[] u2R = {"qwe","123","admin2"};
        String[] u3R = {"qwe","123","not admin"};
        User u1 = new User(u1R);
        User u2 = new User(u2R);
        User u3 = new User(u3R);


        ObjectAccess objAccess = new ProxyAccess();
        objAccess.access(u1.rights);
        objAccess.access(u2.rights);
        objAccess.access(u3.rights);
    }
}

interface ObjectAccess{

    void access(String[] rString);
}

class SomeObjectAccess implements ObjectAccess{

    @Override
    public void access(String[] rString) {
        System.out.println("file accessed");
        
    }
    
}

class ProxyAccess implements ObjectAccess {

    private ObjectAccess objAccess = new SomeObjectAccess();

    @Override
    public void access(String[] rString) {
        for ( String right : rString){
            if ( right == "admin"){
                objAccess.access(rString);
                return;
            }
        }
        System.out.println("access denied");
    }
    
}


class User {
    String[] rights;
    User(String[] rString){
        rights = rString;
    }
}