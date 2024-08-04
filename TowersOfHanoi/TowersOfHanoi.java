package TowersOfHanoi;

import java.util.Scanner;

public class TowersOfHanoi {


    static void TowerRec(int Disk, String Starter, String Final, String Spare) {
         if (Disk == 1) {
              System.out.println("Disk 1:" + Starter + " ---> " + Final);
               return ;
         }
         TowerRec(Disk - 1, Starter, Spare, Final);

        System.out.println("Disk: " + Disk + Starter + " ---> " + Final);
         TowerRec(Disk - 1, Spare, Final, Starter);
    }
    public static void main(String args[]) {
        Scanner Scanner= new Scanner(System.in);
        System.out.println("Enter number of disks you want to simulate: ");
        int Num = Scanner.nextInt() ;

          TowerRec(Num, "A", "C", "B");


    }



}