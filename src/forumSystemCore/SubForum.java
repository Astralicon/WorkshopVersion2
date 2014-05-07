package forumSystemCore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utility.*;
import user.*;

public class SubForum {
	
	private String subject;
	private List<User> moderators;
	private List<Complaint> complaints;
	private List<Message> messages;
	private List<Suspended> suspendedUsers;
	private String id;
	private static int NEXT_ID;
	
	
	public SubForum(String subject, User admin){
		this.subject = subject;
		moderators = new ArrayList<User>();
		complaints = new ArrayList<Complaint>();
		messages = new ArrayList<Message>();
		suspendedUsers = new ArrayList<Suspended>();
		
		this.id = String.valueOf(NEXT_ID);
		NEXT_ID++;
	}
	public String getId() {return this.id;}
	public String getSubject() {return subject;}
	
	/**
	 * upgrade user to moderator
	 * @param mod
	 * @return
	 */
	public boolean addModerator(User mod){
		if(isModerator(mod))return false;
		this.moderators.add(mod);
		return true;
	}
	/**
	 * user will no longer be a modarator
	 * @param user
	 * @return
	 */
	public boolean removeModerator(User user){
		if (moderators.size()>1)
			return moderators.remove(user);
		else return false;
	}
	/**
	 * chack if the user is a moderator
	 * @param user
	 * @return
	 */
	public boolean isModerator(User user){
		for (int i = 0; i < moderators.size(); i++) {
			if(moderators.get(i) == user) return true;
		}
		return true;
	}
	/**
	 * creating a new message adding it to the subforum
	 * @param user
	 * @param title
	 * @param content
	 * @return
	 */

	public String createMessage(User user, String title, String content){
		//input check needed
		if (!(title.equals("")) || !(content.equals(""))){
		 Message m = new Message(user, title, content);
		 this.messages.add(m);
		 return m.getId();
		}
		
		return null;
	}
	/**
	 * adding a new complaint in this subforum
	 * @param complainer
	 * @param complainee
	 * @param complaint
	 * @return
	 */
	public Complaint complain(User complainer, User complainee, String complaint){
		Complaint com = new Complaint(complainer, complainee, complaint, new Date());
		this.complaints.add(com);
		return com;
		
	}
	/**
	 * suspend a user from a rank
	 * @param toSuspend
	 * @param until
	 * @return
	 */
	public boolean suspend(User toSuspend, Date until){
		if(isSuspended(toSuspend)) return false; 
		Suspended sus = new Suspended(toSuspend, until);
		this.suspendedUsers.add(sus);
		return true;
	}
	/**
	 * check to see if a certain user is suspended
	 * @param user
	 * @return
	 */
	public boolean isSuspended(User user){
		for (int i = 0; i < suspendedUsers.size(); i++) {
			if(suspendedUsers.get(i).getUser() == user) return true;
		}
		return false;
	}
}

	