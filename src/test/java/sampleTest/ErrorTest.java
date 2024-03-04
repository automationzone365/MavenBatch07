package sampleTest;

import java.util.ArrayList;
import java.util.List;

public class ErrorTest {
    public static void main(String arg[]){
        List<Integer> lst= new ArrayList<Integer>();
        int i=0;
        while(true){
            lst.add(10);
            i=i+1;
            System.out.println(i+"\t");
        }

    }
}
