package flashcards;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private Scanner scanner;
    Map<String,String> map;

    public static void main(String[] args) {
        new Main().game();
    }

    void game() {
        scanner = new Scanner(System.in);
        map = new LinkedHashMap<>();
        menu();
    }

    boolean inputKeyIsValid(String input){
        return !map.containsKey(input);
    }
    boolean inputValueIsValid(String input){
        return !map.containsValue(input);
    }


    void checkDefinition(){
        outer: for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("Print the definition of \""+entry.getKey()+"\":");
            String definition = scanner.nextLine();
            if(definition.equals(entry.getValue())){
                System.out.println("Correct answer.");
            }
            else{
                for (Map.Entry<String,String> entry1: map.entrySet()){
                    if(definition.equals(entry1.getValue())){
                        System.out.println("Wrong answer. The correct one is \""+entry.getValue()+"\", you've just written the definition of \""+entry1.getKey()+"\".");
                        continue outer;
                    }
                }
                System.out.println("Wrong answer. The correct one is \"" + entry.getValue() + "\".");
            }
        }
    }
    void menu(){
        boolean end = false;
        while (!end){
            System.out.println("Input the action (add, remove, import, export, ask, exit):");
            String option = scanner.nextLine().toLowerCase();
            switch (option){
                case "add": input();
                    break;
                case "remove": remove();
                    break;
                case "import": importFrom();
                    break;
//            case "export": exportTo();
//                break;
//            case "ask": ask();
//                break;
                case "exit": exit();
                    end = true;
                    break;
            }
        }
    }
    void exit(){
        System.out.println("Bye bye!");
        return;
    }
    void input(){
        System.out.println("The card:");
        boolean keX = false;
        while (!keX) {
            String key = scanner.nextLine();
            if (inputKeyIsValid(key)) {
                keX = true;
                System.out.println("The definition of the card:");
                boolean valX = false;
                while (!valX) {
                    String value = scanner.nextLine();
                    if (inputValueIsValid(value)) {
                        valX = true;
                        map.put(key, value);
                        System.out.println("The pair (\""+key+":"+value+"\") has been added.\n");
                    } else {
                        System.out.println("The definition \"" + value + "\" already exists.\n");
                        break;
                    }
                }
            } else {
                System.out.println("The card \"" + key + "\" already exists.\n");
                break;
            }
        }
    }
    void remove(){
        System.out.println("The card:");
        String key = scanner.nextLine();
        if(map.containsKey(key)){
            map.remove(key);
            System.out.println("The card has been removed.\n");
        }else{
            System.out.println("Can`t remove \""+key+"\": there is no such card.\n");
        }
    }
    void importFrom(){
        System.out.println("File name:");
        String[] entries = null;
        try {
            String fileName = "./Flashcards/task/src/flashcards/"+scanner.nextLine();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while (true){
                line = fileReader.readLine();
                if(line == null){break;}
                else {
                    entries = line.split(" ");
//                    for (String s:entries) {
//                        System.out.println(s);
//                    }
                    for (int i = 0; i < entries.length; i++) {
                        String[] pairs = entries[i].split(":");
                        map.put(pairs[0], pairs[1]);
                    }
                    System.out.println(entries.length + " cards have been saved.\n");
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
