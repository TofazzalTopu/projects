package com.info.MongoDBDemo.controller;

import com.info.MongoDBDemo.model.Person;
import com.info.MongoDBDemo.repository.PersonRepository;
import com.info.MongoDBDemo.service.PersonService;
import org.apache.poi.xwpf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Created by mdtofazzal.hossain on 2/25/2019.
 */

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    public static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    PersonService personService;
    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/create")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {
        Person p = personService.create(firstName, lastName, age);

        return p.toString();
    }


    @RequestMapping(value = "/get", produces= MediaType.APPLICATION_JSON_VALUE)
    public Person getPerson(@RequestParam String firstName) {
        return personService.getByFirstName(firstName);
    }

    @RequestMapping("/findById")
    public Person findByPersonId(@RequestParam Integer id) {
        Person p = personService.findById(id);
        return p;
    }

    @RequestMapping("/getAll")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @RequestMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {
        Person p = personService.update(firstName, lastName, age);
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName) {
        personService.delete(firstName);
        return "Deleted " + firstName;
    }

    @RequestMapping("/deleteAll")
    public String deleteAll() {
        personService.deleteAll();
        return "Delete all records.";
    }

    @RequestMapping(value = "/success")
    public String success() {
        return "Successfully saved.";
    }

    @RequestMapping(value = "/reverseString")
    public void reverseString() {
        System.out.println("Enter string to reverse:");

        Scanner read = new Scanner(System.in);
        String str = read.nextLine();


        StringBuilder stringBuilder = new StringBuilder();
        for (int j = str.length() - 1; j >= 0; j--) {
            stringBuilder.append(str.charAt(j));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        System.out.println("Reversed string is:");
        System.out.println(sb.toString());
        System.out.println("Reversed stringBuilder is: " + stringBuilder.toString());

//        String input = "GeeksforGeeks";

        // getBytes() method to convert string
        // into bytes[].
        byte[] strAsByteArray = str.getBytes();

        byte[] result =
                new byte[strAsByteArray.length];

        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] =
                    strAsByteArray[strAsByteArray.length - i - 1];

        System.out.println("Str As Byte Array " + new String(result));
    }

    @RequestMapping(value = "/exportFile")
    public static String exportFile() throws Exception {

        //Create a document
        //Blank Document
        XWPFDocument document = new XWPFDocument();

        File dir = new File("D://Projects//MongoDBDemo//src//main//resources//createDocument//");
        if(!dir.exists()){
            dir.mkdirs();
        }
        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File(dir, "createDocument.docx"));
        document.write(out);
        out.close();
        System.out.println("createDocument.docx written successully");


        //Write the Document in file system
        FileOutputStream output = new FileOutputStream(new File(dir , "fontStyle.docx"));

        //create paragraph
        XWPFParagraph paragraph = document.createParagraph();

        //Set Bold an Italic
        XWPFRun paragraphOneRunOne = paragraph.createRun();
        paragraphOneRunOne.setBold(true);
        paragraphOneRunOne.setItalic(true);
        paragraphOneRunOne.setText("Font Style");
        paragraphOneRunOne.addBreak();

        //Set text Position
        XWPFRun paragraphOneRunTwo = paragraph.createRun();
        paragraphOneRunTwo.setText("Font Style two");
        paragraphOneRunTwo.setTextPosition(100);

        //Set Strike through and Font Size and Subscript
        XWPFRun paragraphOneRunThree = paragraph.createRun();
        paragraphOneRunThree.setStrike(true);
        paragraphOneRunThree.setFontSize(20);
        paragraphOneRunThree.setSubscript(VerticalAlign.SUBSCRIPT);
        paragraphOneRunThree.setText(" Different Font Styles");

        document.write(output);
        output.close();
        System.out.println("fontstyle.docx written successully");

        //Write the Document in file system
         out = new FileOutputStream(new File(dir, "alignParagraph.docx"));

        //create paragraph
         paragraph = document.createParagraph();
//        XWPFParagraph paragraph = document.createParagraph();

        //Set alignment paragraph to RIGHT
        paragraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFRun run = paragraph.createRun();
        run.setText("At tutorialspoint.com, we strive hard to " +
                "provide quality tutorials for self-learning " +
                "purpose in the domains of Academics, Information " +
                "Technology, Management and Computer Programming " +
                "Languages.");

        //Create Another paragraph
        paragraph = document.createParagraph();

        //Set alignment paragraph to CENTER
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        run = paragraph.createRun();
        run.setText("The endeavour started by Mohtashim, an AMU " +
                "alumni, who is the founder and the managing director " +
                "of Tutorials Point (I) Pvt. Ltd. He came up with the " +
                "website tutorialspoint.com in year 2006 with the help" +
                "of handpicked freelancers, with an array of tutorials" +
                " for computer programming languages. ");

        document.write(out);
        out.close();
        System.out.println("alignParagraph.docx written successfully");

        return "Congratulations alignParagraph.docx written successfully";
    }
}

