/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa_assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dinish
 */
public class Application {

    BinarySearchTree tree = new BinarySearchTree();

    private String userInput() {
        String s = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            s = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    /**
     *
     * @return true when operation successful false when operation failed
     */
    public boolean addBook() {
        String ISBN;
        String bnm;
        String fnm;
        String snm;
        System.out.println("ISBN \nEg: 1234567890123 \nISBN have 13 digits\n");
        System.out.print("Enter ISBN: ");
        ISBN = userInput();
        boolean a = isISBNValid(ISBN);
        if (a) {
            double key = Double.parseDouble(ISBN);
            System.out.print("Enter Book Name: ");
            bnm = userInput();
            System.out.print("Enter Author First Name: ");
            fnm = userInput();
            System.out.print("Enter Author Surname: ");
            snm = userInput();
            a = tree.addNode(key, bnm, fnm, snm);
            return a;
        } else {
            System.out.println("\nInvaild ISBN !");
            return a;
        }
    }

    public boolean removeBookByISBN() {
        String ISBN;
        System.out.print("Enter ISBN: ");
        ISBN = userInput();
        boolean a = isISBNValid(ISBN);
        if (a) {
            double key = Double.parseDouble(ISBN);
            a = tree.deleteByKey(key);
            if (a) {
                System.out.println("Book with ISBN:" + ISBN + " is deleted");
                return a;
            } else {
                System.out.println("\nInvaild ISBN !");
                return a;
            }
        } else {
            System.out.println("\nInvaild ISBN !");
            return a;
        }
    }

    public boolean removeBookByName() {
        boolean a = false;
        String book;
        System.out.print("Enter Book name: ");
        book = userInput();
        a = tree.deteleByBookName(book);
        if (a) {
            System.out.println("Book with name:" + book + " is deleted");
            System.out.println("");
            return true;
        } else {
            System.out.println("\nInvaild Book name !");
            return false;
        }

    }

    public boolean searchBookByISBN() {
        String ISBN;
        System.out.print("Enter ISBN: ");
        ISBN = userInput();
        boolean a = isISBNValid(ISBN);
        if (a) {
            double key = Double.parseDouble(ISBN);
            Node node = tree.searchByKey(key);
            if (node == null) {
                System.out.println("Can found Book with this ISBN");
                return false;
            } else {
                System.out.println("\nISBN: " + doubleToStringOFKey(node.key));
                System.out.println("Book: " + node.b_name);
                System.out.println("Author's First name: " + node.f_name);
                System.out.println("Author's Surname: " + node.s_name);
                return true;
            }
        } else {
            System.out.println("\nInvaild ISBN !");
            return a;
        }
    }

    public boolean searchBookByName() {
        String book;
        System.out.print("Enter Book name: ");
        book = userInput();

        Node node = tree.searchByBookName(book);
        if (node == null) {
            System.out.println("Can found Book with this ISBN");
            return false;
        } else {
            System.out.println("\nISBN: " + doubleToStringOFKey(node.key));
            System.out.println("Book: " + node.b_name);
            System.out.println("Author's First name: " + node.f_name);
            System.out.println("Author's Surname: " + node.s_name);
            return true;
        }
    }

    public void start() {
        dataload();
        boolean state = true;
        while (state) {
            userInput();
            System.out.println("1. Add a Book");
            System.out.println("2. Remove Book by ISBN");
            System.out.println("3. Remove Book by name of the book");
            System.out.println("4. Search Book by ISBN");
            System.out.println("5. Search Book by name of the book");
            System.out.println("6. Exit");
            System.out.print("\n Enter Option Number :");
            String userInput = userInput();
            System.out.println("\n");
            try {
                boolean op = false;
                int i = Integer.parseInt(userInput);
                switch (i) {
                    case 1:
                        op = addBook();
                        break;
                    case 2:
                        op = removeBookByISBN();
                        break;
                    case 3:
                        op = removeBookByName();
                        break;
                    case 4:
                        op = searchBookByISBN();
                        break;
                    case 5:
                        op = searchBookByName();
                        break;
                    case 6:
                        op = true;
                        state = false;
                        break;
                    default:
                        System.out.println("Invalid Option !!!");
                        break;
                }
                if (op) {
                    System.out.println("Operation Successful");
                    System.out.println("\n\n");
                } else {
                    System.out.println("Operation Faild");
                    System.out.println("\n\n");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid Input");
            }
        }
    }

    private boolean isISBNValid(String userInput) {
        try {
            Double key = Double.parseDouble(userInput);
            if (userInput.length() != 13) {
                throw new NumberFormatException();
            }
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }

    }

    private String doubleToStringOFKey(double key) {
        String n = String.valueOf(key);
        n = n.substring(0, 14);
        n = n.replace('.', ':');
        String[] s = n.split(":");
        n = s[0] + s[1];
        return n;
    }

    public void dataload() {
        tree.addNode(6786001191251d, "Thinking In Java", "Bruce", "Eckel");
        tree.addNode(3786001191062d, "The elements of Java style", "Scott", "Ambler");
        tree.addNode(3786001184075d, "Effective Java", "Joshua", "Bloch");
        tree.addNode(9786001183990d, "Head First design patterns", "Eric", "Freeman");
        tree.addNode(8785945583905d, "PHP and MySQL Web Development", "Luke", "Welling");
        tree.addNode(8727089728320d, "PHP 4 Bible", "Tim", "Converse");
        tree.addNode(1727089655864d, "PHP 4: A Beginner's Guide", "Bill", "McCarty");
        tree.addNode(2786325955707d, "PHP Functions Essential Reference", "Torben", "Wilson");
        tree.addNode(1786703422290d, "Programming PHP ", "Rasmus", "Lerdorf");
        tree.addNode(1130588189933d, "PHP Functions Essential Reference", "Torben", "Wilson");
        tree.addNode(2115514789655d, "PHP Object-Oriented Solutions ", "David", "Powers");
        tree.addNode(7561993138507d, "Head First PHP & MySQL", "Michael", "Morrison");
        tree.addNode(1222180496829d, "Head First Java, 2nd Edition ", "Kathy", "Sierra");
        tree.addNode(4993355853224d, "Java: How to Program, 8th Edition", "P.J.", "Deitel");
        tree.addNode(9052083632623d, "The Java Programming Language, 4th Edition ", "Ken ", "Arnold");
        tree.addNode(5600296084786d, "Securing PHP Web Applications ", "Tricia", "Ballad");
        tree.addNode(8448938360606d, "Java Concurrency in Practice", "Brian  ", "Goetz");
        tree.addNode(3472479731436d, "Java Generics and Collections ", "Philip  ", "Wadler");
        tree.addNode(7124428189487d, "Java In A Nutshell, 5th Edition ", "David  ", "Flanagan");
        tree.addNode(1001001001001d, "Java", "Dinish ", "De Silva");
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();

    }

}
