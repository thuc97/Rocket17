package entity.vti;


public class CandidateB extends Candidates {
		private String examKhoiB = "Math, Chemistry, Disciple";

		public CandidateB(String candidateNumber, String name, String adres, Priority priority) {
			super(candidateNumber, name, adres, priority);
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString()+examKhoiB;
		}
}

