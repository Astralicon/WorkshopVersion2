package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import forumSystemCore.*;
import utility.*;
import user.*;

public class Query {

	public static void save(Rank rank) throws ClassNotFoundException, SQLException {
		Executor.run("DELETE FROM `Ranks` WHERE `name` = '" + rank.getName() + "'");
		Executor.run("INSERT INTO `Ranks`(" + 
				"`name`, " + 
				"`CREATE_FORUM`, " + 
				"`SET_FORUM_PROPERTIES`, " + 
				"`CREATE_SUB_FORUM`, " + 
				"`CREATE_MESSAGE`, " + 
				"`SET_RANKS`, " + 
				"`SET_USER_RANK`, " + 
				"`DELETE_MESSAGE`, " + 
				"`DELETE_SUB_FORUM`, " + 
				"`ADD_ADMIN`, " + 
				"`REMOVE_ADMIN`, " + 
				"`ADD_MODERATOR`, " + 
				"`REMOVE_MODERATOR`" + 
			") VALUES (" + 
				"'" + rank.getName() + "', " + 
				"'" + (rank.hasPermission(Permissions.CREATE_FORUM)) + "', " + 
				"'" + (rank.hasPermission(Permissions.SET_FORUM_PROPERTIES)) + "', " + 
				"'" + (rank.hasPermission(Permissions.CREATE_SUB_FORUM)) + "', " + 
				"'" + (rank.hasPermission(Permissions.CREATE_MESSAGE)) + "', " + 
				"'" + (rank.hasPermission(Permissions.SET_RANKS)) + "', " + 
				"'" + (rank.hasPermission(Permissions.SET_USER_RANK)) + "', " + 
				"'" + (rank.hasPermission(Permissions.DELETE_MESSAGE)) + "', " + 
				"'" + (rank.hasPermission(Permissions.DELETE_SUB_FORUM)) + "', " + 
				"'" + (rank.hasPermission(Permissions.ADD_ADMIN)) + "', " + 
				"'" + (rank.hasPermission(Permissions.REMOVE_ADMIN)) + "', " + 
				"'" + (rank.hasPermission(Permissions.ADD_MODERATOR)) + "', " + 
				"'" + (rank.hasPermission(Permissions.REMOVE_MODERATOR)) + "'" + 
			")");
	}

	public static void save(Complaint comp) throws ClassNotFoundException, SQLException {
		Executor.run("DELETE FROM `Complaints` WHERE `id` = '" + comp.getId() + "'");
		Executor.run("INSERT INTO `Ranks`(" + 
				"`id`, " + 
				"`complainer`, " + 
				"`complainee`, " + 
				"`complaintMessage`, " + 
				"`date`" + 
			") VALUES (" + 
				"'" + comp.getId() + "', " + 
				"'" + comp.getComplainer() + "', " + 
				"'" + comp.getComplainee() + "', " + 
				"'" + comp.getComplaintMessage() + "', " + 
				"'" + comp.getDate() + "'" + 
			")");
	}

	public static void save(User user) throws ClassNotFoundException, SQLException {
		Executor.run("DELETE FROM `Users` WHERE `username` = '" + user.getUsername() + "'");
		Executor.run("INSERT INTO `Ranks`(" + 
				"`mail`, " + 
				"`name`, " + 
				"`username`, " + 
				"`password`, " + 
				"`rank`" + 
			") VALUES (" + 
				"'" + user.getMail() + "', " + 
				"'" + user.getName() + "', " + 
				"'" + user.getUsername() + "', " + 
				"'" + user.getPassword() + "', " + 
				"'" + user.getRank().getName() + "'" + 
			")");
	}

	public static void save(SubForum sf) throws ClassNotFoundException, SQLException {
		Executor.run("DELETE FROM `SubForums` WHERE `id` = '" + sf.getId() + "'");
		Executor.run("INSERT INTO `Ranks`(" + 
				"`id`, " + 
				"`subject`" +
			") VALUES (" + 
				"'" + sf.getId() + "', " + 
				"'" + sf.getSubject() + "'" + 
			")");
	}

	public static void save(Forum forum) throws ClassNotFoundException, SQLException {
		Executor.run("DELETE FROM `Forums` WHERE `id` = '" + forum.getId() + "'");
		Executor.run("INSERT INTO `Ranks`(" + 
				"`id`, " + 
				"`name`" +
			") VALUES (" + 
				"'" + forum.getId() + "', " + 
				"'" + forum.getName() + "'" + 
			")");
	}
	
}