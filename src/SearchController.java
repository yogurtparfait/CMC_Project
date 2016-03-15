import java.util.List;

public class SearchController {

	private DBController database;
	public SearchController(){
		database = new DBController();
	}
	
	public List<School> search(String name,String state,String location,String control,
			int numStudents,double percentFemale,int SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale,
			String[] emphases){
		
	
		return database.search(name, state, location, control, numStudents, percentFemale, 
				SATVerb, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, 
				percentEnrolled, academicsScale, socialScale, qualityOfLifeScale, emphases);
	}
	public List<School> recommendations(School s){
		return database.recommendations(s);
	}
}
