package com.revature;

import com.revature.menu.MainMenu;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in); // static field -> global variable

    public static void main(String[] args) {
        MainMenu mainMenuObject = new MainMenu(); // Instantiating a MainMenu object

        mainMenuObject.display(); // calling the display method on the MainMenu object
    }
}