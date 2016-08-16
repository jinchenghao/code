package com;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q1 {


    public static void main(String[] arg){
        Scanner scan=new Scanner(System.in);
        Set<String> res = new HashSet<>();
        while(scan.hasNext()){
            String s = scan.next();
            if(s.equals("end")) {
                break;
            }
            res.add(s);    
        }
        System.out.println(res.size());
        scan.close();
    }
}


