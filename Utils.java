package edu.waketech.csc251.tools;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Static methods to display list-like information to the user, and handle
 * menus.
 * 
 * @author parks
 *
 */
public class Utils {

   /**
    * Display a given menu to the user and ask for a selection.
    * 
    * @param <E>
    *           Type of elements in the choices array.  Their toString values will be displayed
    * 
    * @param kybd
    *           Scanner bound to the keyboard or other user input
    * @param choices
    *           an array of user choices
    * @return the user's choice toString value
    */
   public static <E> String userChoose(Scanner kybd, E[] choices) {
      int choice = -1;
      System.out.println("Make a Selection: ");
      for (int i = 0; i < choices.length; i++) {
         System.out.println("\t[" + i + "] " + choices[i].toString());
      }
      
      try {
         String s = kybd.next();
         choice = Integer.parseInt(s);
      } catch (NumberFormatException e) {
         System.out.println("Invalid Choice");
         return "";
      }

      if (choice < 0 || choice >= choices.length) {
         System.out.println("Invalid Choice");
         return "";
      }
      return choices[choice].toString();
   }

   /**
    * Display a given menu to the user and ask for a selection.
    * 
    * @param <E>
    *           Type of elements in the choices list.  Their toString values will be displayed
    * 
    * @param kybd
    *           Scanner bound to the keyboard or other user input
    * @param choices
    *           an ArrayList of user choices
    * @return the user's choice toString value
    */
   public static <E> String userChoose(Scanner kybd, ArrayList<E> choices) {
      int choice = -1;
      System.out.println("Make a Selection: ");
      for (int i = 0; i < choices.size(); i++) {
         System.out.println("\t[" + i + "] " + choices.get(i).toString());
      }
      
      try {
         String s = kybd.next();
         choice = Integer.parseInt(s);
      } catch (NumberFormatException e) {
         System.out.println("Invalid Choice");
         return "";
      }
      
      if (choice < 0 || choice >= choices.size()) {
         System.out.println("Invalid Choice");
         return "";
      }
      return choices.get(choice).toString();
   }

   /**
    * Display a given list of items to the user and wait for the user to
    * acknowledge it.
    * 
    * @param <E>
    *           Type of elements in the choices array.  Their toString values will be displayed
    * 
    * @param kybd
    *           Scanner bound to the keyboard or other user input
    * @param info
    *           an array of information to be displayed
    */
   public static <E> void userDisplay(Scanner kybd, E[] info) {
      for (int i = 0; i < info.length; i++) {
         System.out.println("\t[" + i + "] " + info[i]);
      }
      System.out.println("Press any key and enter to Continue: ");
      kybd.next();
   }

   /**
    * Display a given list of items to the user and wait for the user to
    * acknowledge it.
    * 
    * @param <E>
    *           Type of elements in the choices list.  Their toString values will be displayed
    * 
    * @param kybd
    *           Scanner bound to the keyboard or other user input
    * @param info
    *           an ArrayList of information to be displayed
    */
   public static <E> void userDisplay(Scanner kybd, ArrayList<E> info) {
      for (int i = 0; i < info.size(); i++) {
         System.out.println("\t[" + i + "] " + info.get(i));
      }
      System.out.println("Press any key and enter to Continue: ");
      kybd.next();
   }
}
