package org.edwith.webbe.guestbook.service;

import java.util.List;

import org.edwith.webbe.guestbook.dto.Guestbook;

public interface GuestbookService {		//서비스상에서 필요한 객체 (화면에 보여지는)
	public static final Integer LIMIT = 5;
	public List<Guestbook> getGuestbooks(Integer start);
	public int deleteGuestbook(Long id, String ip);
	public Guestbook addGuestbook(Guestbook guestbook, String ip);
	public int getCount();
}