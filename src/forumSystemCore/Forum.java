package forumSystemCore;
import java.util.ArrayList;
import java.util.Date;

import utility.*;
import user.*;

public class Forum {
	private String name;
	private Policy policy;
	private ArrayList<User> administrators;
	private ArrayList<User> members;
	private ArrayList<SubForum> subForums;
	private ArrayList<Rank> ranks;
	private String id;
	
	//constructor
	public Forum(String name, User admin){
		setId();
		this.name = name; 
		this.policy = new Policy();
		this.administrators = new ArrayList<User>();
		this.members = new ArrayList<User>();
		this.subForums = new ArrayList<SubForum>();
		this.ranks = new ArrayList<Rank>();
		administrators.add(admin);
	}
	//Getters:
	public String getName(){
		return name;
	}
	
	public String getId(){
		return id;
	}
	//Methods:
	public User login(String username, String password) {
		for (int i=0; i<members.size(); i++) 
			if (members.get(i).getUsername().equals(username) && 
					members.get(i).getPassword().equals(password)) return members.get(i);
		return null;
	}
	
	public String createSubForum(User invoker ,User moderator, String subForumName) {
		if (!invoker.hasPermission(Permissions.CREATE_SUB_FORUM) || !TextVerifier.verifyName(subForumName, new Policy()) || moderator == null) return null;
		
		SubForum newSF = new SubForum(subForumName, moderator);
		subForums.add(newSF);
		return newSF.getId();
	}
	
	public boolean deleteSubForum(User invoker, String subForumId) {
		if (!invoker.hasPermission(Permissions.DELETE_SUB_FORUM)) return false;
		boolean found = false; 
		for (int i=0; i<subForums.size() && !found; i++) {
			if (subForums.get(i).getId().equals(subForumId)) {
				found = true;
				subForums.remove(i);
			}
		}
		return found; 
	}
	
	public boolean addAdmin(User invoker, User adminToAdd) {
		if (!invoker.hasPermission(Permissions.ADD_ADMIN)) return false;
		administrators.add(adminToAdd);
		return true;
	}
	
	public boolean removeAdmin(User invoker, User adminToRemove) {
		if (!invoker.hasPermission(Permissions.REMOVE_ADMIN)) return false;
		boolean found = false; 
		for (int i=0; i<administrators.size() && !found; i++) {
			if (administrators.get(i) == adminToRemove) {
				found = true;
				administrators.remove(i);
			}
		}
		return true;		
	}
	
	public boolean addModerator(String subForumId, User invoker, User moderator) {
		if (!invoker.hasPermission(Permissions.ADD_MODERATOR)) return false;
		getSubForumById(subForumId).addModerator(moderator);
		return true; 
	}
	
	public boolean removeModerator(String subForumId, User invoker, User moderator) {
		if (!invoker.hasPermission(Permissions.REMOVE_MODERATOR)) return false;
		getSubForumById(subForumId).removeModerator(moderator);
		return true; 
	}
	
	public boolean suspend(String subforumId, User admin, User toSuspend, Date until) {
		if (!isAdmin(admin)) return false;
		return getSubForumById(subforumId).suspend(toSuspend, until);
	}
	
	public User signup(String mail, String name, String username, String password) {
		if (!TextVerifier.verifyEmail(mail) || !TextVerifier.verifyName(username, policy) || !TextVerifier.verifyPassword(password, policy) || name.equals("")) return null;
		User member = new User(mail, name, username, password, Rank.member);
		this.members.add(member);
		return member;
	}
	
	//AUX Methods:
	public boolean isAdmin(User user) {
		return administrators.contains(user);
	}
	
	protected SubForum getSubForumById(String id) {
		for (int i=0; i<subForums.size(); i++) if (id.equals(subForums.get(i).getId())) return subForums.get(i);
		return null;
	}
	
	private static int nextId = 0;
	private void setId() {
		this.id = nextId++ + "";
	}
	public boolean isMember(User user) {
		if (this.isAdmin(user)) return true;
		for (int i = 0; i < members.size(); i++) {
			if(members.get(i)==user) return true;
		}
		return false;
	}
	public boolean existSubForum(String subForumid) {
		for (int i = 0; i < subForums.size(); i++) {
			if(subForums.get(i).getId().equals(subForumid)) return true;
		}
		return false;
	}
}