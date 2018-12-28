package O_O.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserContents {

    //理解的还不好，不知道这样对不对
    private static HashMap<String, String> userContents = new HashMap<>();

    private static class InstanceHolder {
        private static final UserContents sInstance = new UserContents();
    }

    private UserContents() {
    }

    public static UserContents getInstance() {
        return InstanceHolder.sInstance;
    }

    public void put(String key, String value){
        userContents.put(key, value);
    }

    public void remove(String key){
        userContents.remove(key);
    }

    public boolean containsKey(String token){
        return userContents.containsKey(token);
    }

    public String get(String key){
        return userContents.get(key);
    }

    public void deleteAll(){
        for(Iterator<Map.Entry<String, String>> it = userContents.entrySet().iterator(); it.hasNext();){
            Map.Entry<String, String> item = it.next();
            it.remove();
        }
    }

    public boolean isLogin(){
        return ! userContents.isEmpty();
    }
}
