package entity.vti;

public class CandidateC extends Candidates {
	private String examKhoiC = "Literature, History, Geography";

	public CandidateC(String candidateNumber, String name, String adres, Priority priority) {
		super(candidateNumber, name, adres, priority);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+examKhoiC;
	}
}
