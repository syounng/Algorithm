import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<String> names = new ArrayList<>();
        for(int i=0; i<num; i++){
            names.add(sc.next());
        }
        int result = 0;
        for(int i=0; i<num-1; i++){
            int compare = names.get(i).compareTo(names.get(i+1));
            if(compare > 0){
                result--;
            }else if(compare < 0){
                result++;
            }
        }
        if(result == num-1){
            System.out.println("INCREASING");
        }else if(result + (num-1) == 0){
            System.out.println("DECREASING");
        }else{
            System.out.println("NEITHER");
        }

    }
}