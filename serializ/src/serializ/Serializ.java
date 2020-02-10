package serializ;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

    class Test implements Serializable{
        static final long serialVersionUID = 1;
        String name = "as";
         Date date;
        int d;
        public Test (int d, Date date)
        {
        this.d = d;
        this.date = date;
        System.out.println(date);
        }
        
    }

public class Serializ {
    public static void main(String[] args) throws Exception {

      Scanner sc = new Scanner(System.in);
        System.out.println("Linq 1 or 2 for write or read \n3 for Exit");
        A:
        while(true)
        {
      switch(sc.nextInt())
      {
          case 1:
        FileOutputStream f = new FileOutputStream("Test.txt"); //запись
        ObjectOutputStream s = new ObjectOutputStream(f);
        Test t = new Test(5, new Date());
        s.writeObject(t);
        s.close();
              break;
          case 2:
        FileInputStream ff = new FileInputStream("Test.txt"); //чтение
        ObjectInputStream ss = new ObjectInputStream(ff);
        Test tt = (Test)ss.readObject();
        System.out.println(" Loaded.obj \n" + tt.date + "//"+ tt.d);
        System.out.println(" this.obj : \n" +new Date());
        ss.close();
              break;
          case 3:
              System.out.println("EXIT");
              break A;
          default: break A;
      }
        }

       // Paths.get(".");
    }

}
