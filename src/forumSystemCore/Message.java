package forumSystemCore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import user.*;
import utility.*;

public class Message {
	private static int NEXT_ID=0;
	private Date date;
	private String content;
	private String title;
	private List<Message> replies;
	private User writer;
	//special id
	private String id;
	
	public Message(User user, String title, String content) {
		this.writer=user;
		this.title = title;
		this.content = content;
		this.date = new Date();
		this.replies = new ArrayList<Message>();
		
		this.id = String.valueOf(NEXT_ID);
		NEXT_ID++;
	}
	public String getId(){return this.id;}

	
	/**
	 * adding a new reply to this message
	 * @param user
	 * @param title
	 * @param content
	 * @return
	 */
	public Message addReply(User user, String title, String content){
		Message m = new Message(user, title, content);
		replies.add(m);
		return m;
	}
	/**
	 * remove reply to this message
	 * @param user
	 * @param message
	 * @return
	 */
	public boolean removeReply(User user, Message message){
		if(user.hasPermission(Permissions.DELETE_MESSAGE) || message.isWriter(user)){
			replies.remove(message);
			return true;
		}
		return false;
	}
	/**
	 * return true if user is this message writer, false otherwise
	 * @param user
	 * @return
	 */
	public boolean isWriter(User user){
		return this.writer==user;
	}
	
	/**
	 * edit  the info
	 * @param title
	 * @param content
	 * @return
	 */
	public boolean editMessage(String title, String content){
		if(title!=null)this.title =title;
		if(content!=null)this.content = content;
		return true;
	}
	

}
