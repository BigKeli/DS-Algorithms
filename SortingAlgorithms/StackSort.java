package SortingAlgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> MainStack = new Stack<>();
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Enter amount of numbers you want in Stack (no duplicates pls): ");
        int Amount = Scanner.nextInt();
        for (int i = 0; i < Amount; i++) {
            MainStack.add(Scanner.nextInt());
        }
        System.out.println("Stack before sort: "+ MainStack);
        System.out.print("Stack after sort:  "+sortStack(MainStack));
    }

    public static Stack sortStack(Stack<Integer> MainStack){

        Queue<Integer> TempQueue = new LinkedList<>();
        int size= MainStack.size();
        for (int i = 0; i < size-1; i++) {
            int value = MainStack.pop();
            while(!(MainStack.isEmpty())){
                if (value > MainStack.peek()) {
                    TempQueue.add(value);
                    value = MainStack.pop();
                } else if(value < MainStack.peek()) {
                    TempQueue.add(MainStack.pop());
                } else if (value == MainStack.peek()) {
                    TempQueue.add(value);
                }
                if (MainStack.size()==i){
                    MainStack.add(value);
                    break;}
            }

            int BSize= TempQueue.size();

            for (int j = 0; j <BSize ; j++) {
                MainStack.add(TempQueue.poll());
            }
        }
        return MainStack;
    }



}