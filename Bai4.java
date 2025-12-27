/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kiemtra01;
import java.io.*;
import java.util.*;
public class Bai4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("DAYSO.in"));
        int t = Integer.parseInt(in.nextLine());
        while(t-->0){
            int n = in.nextInt();
            int[] a = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0;i<n;i++){
                a[i] = in.nextInt();
                if(map.containsKey(a[i])){
                    map.put(a[i],map.get(a[i])+1);
                }else{
                    map.put(a[i],1);
                    arr.add(a[i]);
                }
            }
            Collections.sort(arr,new Comparator<Integer>(){
                public int compare(Integer a, Integer b){
                    return map.get(b)- map.get(a);
                }
            });
            for(Integer x : arr){
                if(map.get(x) != 0){
                    int y = map.get(x);
                    while(y-->0){
                            System.out.print(x + " ");
                    }
                    map.put(x,0);
                }
            }
            System.out.println();
        }
    } 
}