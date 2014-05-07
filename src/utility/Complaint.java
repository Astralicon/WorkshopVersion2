package utility;
import java.util.Date;
import user.*;

public class Complaint {
	private static int next_cpmlnt_id=0;
	private int id; 
	private User complainer;
	private User complainee;
	private String complaintMessage;
	private Date date;
	private String status; //in process/closed/opened
	
	public Complaint(User complainer,User complainee,String msg, Date date){
		this.status = "Opened";
		this.id = next_cpmlnt_id;
		next_cpmlnt_id++;
		this.complainer=complainer;
		this.complainee=complainee;
		this.complaintMessage=msg;
		this.date=date;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}

	public int getId() {
		return id;
	}

	public User getComplainee() {
		return complainee;
	}

	public String getComplaintMessage() {
		return complaintMessage;
	}

	/**
	 * the complainer can edit his complaint content and complainee
	 * @param u the complainer
	 * @param u2 the complainee
	 * @param msg 
	 * @return
	 */
	public boolean editComplaint(User u,User u2,String msg) {
		if(u==this.complainer && msg!=null){
			this.complainee=u2;
			this.complaintMessage = msg;
			return true;
		}
		return false;
	}


	


}
