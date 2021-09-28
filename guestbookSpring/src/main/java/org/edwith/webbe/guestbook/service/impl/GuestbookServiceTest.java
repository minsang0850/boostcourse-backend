package org.edwith.webbe.guestbook.service.impl;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.edwith.webbe.guestbook.config.ApplicationConfig;
import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.service.GuestbookService;

public class GuestbookServiceTest {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		GuestbookService guestbookService = ac.getBean(GuestbookService.class);
		
		Guestbook guestbook = new Guestbook();
		guestbook.setName("kang kyungmi");
		guestbook.setContent("반갑습니다. 여러분. 여러분이 재미있게 공부하고 계셨음 정말 좋겠네요^^");
		guestbook.setRegdate(new Date());
		Guestbook result = guestbookService.addGuestbook(guestbook, "127.0.0.1");
		System.out.println(result);
		
	}

}