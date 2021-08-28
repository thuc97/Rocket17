package entity.vti;

public class CandidateA extends Candidates {
	private String examKhoiA = "Math, Physics, Chemistry";
	
	public CandidateA(String candidateNumber, String name, String adres, Priority priority) {
		super(candidateNumber, name, adres, priority);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+ examKhoiA.toString();
	}

}