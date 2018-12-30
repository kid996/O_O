package O_O.db;

import java.io.*;

public class dbTools {
    private static final String FILE_PATH = "C:\\JavaWorkspace\\O_O\\src\\O_O\\db\\Info.txt";

    public static void initClientDB(){
        File file = new File(FILE_PATH);
        try {
            file.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean addToken(String token){
        File file = new File(FILE_PATH);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(token);
            bw.close();
            System.out.println("add a new token!");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static String getToken(){
        File file = new File(FILE_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String token = br.readLine();
            br.close();
            return token;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String [] args){
//        addToken("123sss");
        System.out.println(getToken());
    }
}
