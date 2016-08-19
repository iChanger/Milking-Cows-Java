/*
ID: ichangs1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
  
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
    int[] interval = new int[1000000];
    int lines = Integer.parseInt(f.readLine());
    int start = 0; 
    int end = 0;
    int cont = 0;
    int idle = 0;
    int realCont = 0;
    int realIdle = 0;
    for( int i = 0; i < lines; i++)
    {
        String times = f.readLine();
        StringTokenizer st = new StringTokenizer(times);
        int time1 = Integer.parseInt(st.nextToken());
        int time2 = Integer.parseInt(st.nextToken());
        for( int j = time1; j < time2; j++){
            interval[j] += 1;
        }
        if( start == 0 || time1 < start){ //Possibly try start = Math.min(start, time1) instead
            start = time1;
        }
        if( end == 0 || time2 > end){ //Possibly try end = Math.max(end, time2) instead
            end = time2;
        }
    }
    
    for(int i = start; i <= end; i++){
        if(interval[i] > 0){
            if( realIdle == 0 || idle > realIdle){
                realIdle = idle;
            }
            if( realCont == 0 || cont > realCont){
                realCont = cont;
            }
            idle = 0;
            cont++;
        }
        else{
            if( realIdle == 0 || idle > realIdle){
                realIdle = idle;
            }
            if( realCont == 0 || cont > realCont){
                realCont = cont;
            }
            cont = 0;
            idle++;
        }
    
    }
    
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
    
    out.print(realCont);
    out.print(" ");
    out.println(realIdle);

 
    out.close();                                  // close the output file
  }
      
}
