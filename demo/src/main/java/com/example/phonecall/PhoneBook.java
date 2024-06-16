package com.example.phonecall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class PhoneBook {

	public  static  Scanner sc = null;
	public  static  final String PHONE_BOOK_FILE_PATH = "C:\\Users\\ledem\\Documents\\PhoneBook.txt";

	public static void main(String[] args) {
		SpringApplication.run(PhoneBook.class, args);
		sc = new Scanner(System.in);

		String userLastName= getUserInput("Geben Sie einen NachNamen ein:  ");
		String userFirstName= getUserInput("Geben Sie einen Vornamen ein:  ");
		String userPhoneNumber= getUserInput("Geben Sie eine Telefonnummer ein:  ");

		Contact newContact = new Contact(userLastName, userFirstName, userPhoneNumber);
		System.out.println("Kontakt: " + newContact.toString());

		//speichern und screiben in eine Datei
		//pathname ist der Pfad zur Datei bzw der weg zur Datei
		File phoneBookFile = getOrCreateFile(PHONE_BOOK_FILE_PATH);
		createContact(phoneBookFile, newContact);

		sc.close();

	}

	public static String getUserInput(String userRequest) {
		System.out.println(userRequest);
        return sc.nextLine();
	}

	//speichern und screiben in eine Datei
	//pathname ist der Pfad zur Datei bzw der weg zur Datei

	public static File getOrCreateFile(String phonebookPathname) {
		File phoneBookFile = new File(phonebookPathname);
		if (phoneBookFile.exists()) {
			return phoneBookFile;
		}
			try {
				phoneBookFile.createNewFile();
				System.out.println("Die Datei wurde erstellt(" + phonebookPathname + ")");
				return phoneBookFile;
			} catch (IOException e) {
				System.out.println("Fehler beim Erstellen der Datei");
				e.printStackTrace();
			}
			return null;
	}

	public  static Contact createContact( File phoneBookFile, Contact newContact) {
		try(BufferedWriter fileWriter = new BufferedWriter(new java.io.FileWriter( phoneBookFile, true))) {//TODO: try with resources
			//BufferedWriter fileWriter = new BufferedWriter(new java.io.FileWriter( phoneBookFile, true));
			fileWriter.append(newContact.toString());
			fileWriter.append('\n');
			System.out.println("Kontakt wurde in die Datei geschrieben");
			//fileWriter.close();
		} catch (IOException e) {
			System.out.println("Fehler beim Erstellen der Datei");
			e.printStackTrace();
		}
		return newContact;
	}
}

