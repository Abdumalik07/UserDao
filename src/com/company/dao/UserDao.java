package com.company.dao;

import com.company.MyException;
import com.company.model.User;
import com.company.service.impl.UserServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserDao extends UserServiceImpl {

    Scanner scanner = new Scanner(System.in);

    public void usersDao(List<User> users){
        String str = "";
       while (!str.equals("r")){
           addUser(users);
           System.out.println("There is operations that working data base of User:");
           System.out.println("---------------------------------------------------------------------------------------------------");
           System.out.println("If you want to find by id press number '1' and Enter." +
                   "\nIf you want to remove by id press number '2' and Enter." +
                   "\nIf you want to get all users press number '3' snd Enter." +
                   "\nIf you want to exit press 'r' and Enter.");
           System.out.println("---------------------------------------------------------------------------------------------------");
           String num = scanner.nextLine();
           try{
               if (Objects.equals(num, "r")) {
                   str = "r";
               }else if (num.matches("[a-zA-Z[^e]]") || num.matches("[123]")) {

                   switch (Integer.parseInt(num)) {
                       case 1 -> {
                           getAllUsers();
                           System.out.println("---------------------------------------------------------------------------------------------------");
                           String c1 = "";
                           while (!c1.equals("r")) {
                               System.out.println("If you want to find by id: press number of id and Enter:\nIf you want to exit: press 'r' and Enter: ");
                               System.out.println("---------------------------------------------------------------------------------------------------");

                               String a = scanner.nextLine();
                               try {
                                   if (a.equals("r")) {
                                       c1 = "r";
                                   } else if (!a.matches("[a-zA-Z[^r]]") || a.matches("[1234567890]")) {
                                       findWithId(Integer.parseInt(a));
                                       System.out.println("---------------------------------------------------------------------------------------------------");
                                   } else
                                       throw new MyException();
                               } catch (MyException e) {
                                   e.myExceptionNoMatches();
                               } catch (NumberFormatException e) {
                                   System.out.println("Number format exception");
                               }
                           }
                       }
                       case 2 -> {
                           String c2 = "";
                           getAllUsers();
                           System.out.println("---------------------------------------------------------------------------------------------------");
                           while (!"r".equals(c2)) {
                               System.out.println("If you want to remove by id press number of id and Enter:\nIf you want to exit press 'r' and Enter: ");
                               System.out.println("---------------------------------------------------------------------------------------------------");
                               try {
                                   String b = scanner.nextLine();
                                   if (b.equals("r")) {
                                       c2 = "r";
                                   } else if (!b.matches("[a-zA-Z[^r]]") || b.matches("[1234567890]") || !users.isEmpty()) {
                                       removeWithId(Integer.parseInt(b));
                                       System.out.println("---------------------------------------------------------------------------------------------------");
                                       getAllUsers();
                                       System.out.println("---------------------------------------------------------------------------------------------------");
                                   } else throw new MyException();
                               } catch (MyException e) {
                                   e.myExceptionNoMatches();
                                   c2 = "r";
                               } catch (NumberFormatException e) {
                                   System.out.println("Number format exception");
                                   c2 = "r";
                               }
                           }
                       }
                       case 3 -> {
                           try {
                               if (!users.isEmpty()) {
                                   System.out.println("All users: ");
                                   getAllUsers();
                                   System.out.println("---------------------------------------------------------------------------------------------------");
                               } else throw new MyException();
                           } catch (MyException e) {
                               e.myExceptionDataBasaIsImpty();
                           }
                       }

                       default -> System.out.println("");
                   }
               }else throw new MyException();

           } catch (MyException e) {
               e.myExceptionNoMatches();
           }catch (NumberFormatException e){
               System.out.println("Number format exception");
               System.out.println("---------------------------------------------------------------------------------------------------");

           }catch (InputMismatchException e){
               System.out.println("Input mismatch exception");
               System.out.println("---------------------------------------------------------------------------------------------------");

           }

       }

    }

}
