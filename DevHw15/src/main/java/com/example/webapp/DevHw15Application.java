package com.example.webapp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DevHw15Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appCont.xml");
		NoteService noteService = context.getBean("noteService", NoteService.class);
		Note note1 = context.getBean("note",Note.class);
		note1.setTitle("first");
		note1.setContent("firstNote");
		System.out.println(note1);
		Note note2=context.getBean("note",Note.class);
		note2.setTitle("second");
		note2.setContent("secondNote");
		System.out.println(note2);
		Note note3=context.getBean("note",Note.class);
		note3.setTitle("third");
		note3.setContent("thirdNote");
		System.out.println(note3);
		noteService.add(note1);
		noteService.add(note2);
		noteService.add(note3);
		System.out.println(noteService.listAll());
		noteService.deleteById(2);
		System.out.println(noteService.listAll());
		System.out.println(noteService.getById(1));
		note3.setTitle("UpThird");
		note3.setContent("UpThirdNote");
		noteService.update(note3);
		System.out.println(noteService.getById(3));
	}
}
