import java.io.*;
import java.math.*;
import java.util.*;


public class Solution {
    public static int getGcd(int a,int b){
        if(b%a == 0){
            return a;
        }
        int r;
       while(b % a != 0){
            r = b % a;
            b = a;
            a = r;
       } 
       return a;
    }
    
    public static int getLcm(int a,int b){
        return ( (a*b) / getGcd(a, b));
    }
    
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt(), m = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[m];
      
      for(int i=0;i<n;i++)
        a[i] = sc.nextInt();
       for(int j=0;j<m;j++)
        b[j]  = sc.nextInt();
        
        int lcm = a[0];
        for(int i=1;i<n;i++)
            lcm = getLcm(lcm, a[i]);
            
        int gcd = b[0];
        for(int j=1;j<m;j++)
            gcd = getGcd(gcd, b[j]);
            
        int cnt = 0;
        for(int k = lcm;k<=gcd; k += lcm){
            if(gcd % k == 0)
                cnt++;   
        }
        System.out.println(cnt);
    }
}
