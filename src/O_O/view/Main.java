package O_O.view;

public class Main {
    public static void main(String[] args){
        Client client = new Client();
        client.initPages();
        try {
            client.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
