package entity.vti;

public class Candidates {
	private String candidateNumber;
	private String name;
	private String adress;
	public Priority priority;
	public enum Priority{
		ONE, TWO, THREE
	}
	
	public String getCandidateNumber() {
		return candidateNumber;
	}
	public Candidates(String candidateNumber, String name, String adress, Priority priority) {
		this.candidateNumber = candidateNumber;
		this.name = name;
		this.adress = adress;
		this.priority = priority;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "candidateNumber: "+candidateNumber+"     name: "+name+"     adress: "+adress+"      priority:" + priority;
	}
}