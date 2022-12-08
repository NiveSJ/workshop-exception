package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

import javax.imageio.IIOException;

public class Main {

    public static void main(String[] args) {

        List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();

        List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List<String> lastNames = new ArrayList<>();
        try {
            lastNames = CSVReader_Writer.getLastNames();
        } catch (IOException e) {
            e.printStackTrace();
        }


        NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);
        // Trying to add female first names

        try {
            // nameService.addFemaleFirstName("Annika");
            nameService.addFemaleFirstName("Ananya");
            nameService.addFemaleFirstName("Alice");


        } catch (DuplicateNameException e) {

            System.out.println("The Female Name" + " " + e.getAttribute() + " " + "Already present.");
        }
        // Trying to add Male first names
        try {
            nameService.addMaleFirstName("Jothi");
            //nameService.addMaleFirstName("Jayanth");
            nameService.addMaleFirstName("Oscar");

        } catch (DuplicateNameException e) {

            System.out.println("The Male Name" + " " + e.getAttribute() + " " + "Already present.");
        }
        // Trying to add Last names
        try {
            nameService.addLastName("Jackobsson");
            //nameService.addLastName("Solai");
            nameService.addLastName("Sjöberg");

        } catch (DuplicateNameException e) {

            System.out.println("The Last Name" + " " + e.getAttribute() + " " + "Already present.");

        }


        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

    }

}
