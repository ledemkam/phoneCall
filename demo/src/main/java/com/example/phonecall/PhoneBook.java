package com.example.phonecall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PhoneBook {

	public  static  Scanner sc = null;

	public static void main(String[] args) {
		SpringApplication.run(PhoneBook.class, args);
		sc = new Scanner(System.in);

		String userLastName= getUserInput("Geben Sie einen NachNamen ein:  ");
		String userFirstName= getUserInput("Geben Sie einen Vornamen ein:  ");
		String userPhoneNumber= getUserInput("Geben Sie eine Telefonnummer ein:  ");

		Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);

		System.out.println("Nachname: " + userLastName);
		System.out.println("Vorname: " + userFirstName);
		System.out.println("Telefonnummer: " + userPhoneNumber);
		System.out.println("Kontakt: " + newContact.toString());

		sc.close();

	}

	public static String getUserInput(String userRequest) {
		System.out.println(userRequest);
        return sc.nextLine();
	}

}
