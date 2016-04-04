package entities;

/**
 * @author Megan Noah Jordan Yang
 *
 */
public class School {
	private String name;
	private String state;
	private String location;
	private String control;
	private int numStudents;
	private double percentFemale;
	private double SATVerb;
	private double SATMath;
	private double expenses;
	private double percentFinancialAid;
	private int numberOfApplicants;
	private double percentAdmitted;
	private double percentEnrolled;
	private int academicsScale;
	private int socialScale;
	private int qualityOfLifeScale;
	private String[] emphases = new String[10];

	public School(){}
	/**
	 * Creates school with all given parameters
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param percentFemale
	 * @param SATVerb
	 * @param SATMath
	 * @param expenses
	 * @param percentFinancialAid
	 * @param numberOfApplicants
	 * @param percentAdmitted
	 * @param percentEnrolled
	 * @param academicsScale
	 * @param socialScale
	 * @param qualityOfLifeScale
	 * @param emphases
	 */
	public School(String name,String state,String location,String control,
			int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale, 
			String[] emphases){
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numStudents = numStudents;
		this.percentFemale = percentFemale;
		this.SATVerb = SATVerb;
		this.SATMath = SATMath;
		this.expenses = expenses;
		this.percentFinancialAid = percentFinancialAid;
		this.numberOfApplicants = numberOfApplicants;
		this.percentAdmitted = percentAdmitted;
		this.percentEnrolled = percentEnrolled;
		this.academicsScale = academicsScale;
		this.socialScale = socialScale;
		this.qualityOfLifeScale = qualityOfLifeScale;
		this.emphases = emphases;
	}
	/**
	 * Creates school with given parameters
	 * @param name
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param percentFemale
	 * @param SATVerb
	 * @param SATMath
	 * @param expenses
	 * @param percentFinancialAid
	 * @param numberOfApplicants
	 * @param percentAdmitted
	 * @param percentEnrolled
	 * @param academicsScale
	 * @param socialScale
	 * @param qualityOfLifeScale
	 */
	public School(String name,String state,String location,String control,
			int numStudents,double percentFemale,double SATVerb,double SATMath,double expenses,
			double percentFinancialAid,int numberOfApplicants,double percentAdmitted,
			double percentEnrolled,int academicsScale,int socialScale,int qualityOfLifeScale){
		this.name = name;
		this.state = state;
		this.location = location;
		this.control = control;
		this.numStudents = numStudents;
		this.percentFemale = percentFemale;
		this.SATVerb = SATVerb;
		this.SATMath = SATMath;
		this.expenses = expenses;
		this.percentFinancialAid = percentFinancialAid;
		this.numberOfApplicants = numberOfApplicants;
		this.percentAdmitted = percentAdmitted;
		this.percentEnrolled = percentEnrolled;
		this.academicsScale = academicsScale;
		this.socialScale = socialScale;
		this.qualityOfLifeScale = qualityOfLifeScale;
	}
	/**
	 * @return name of school
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the control
	 */
	public String getControl() {
		return control;
	}
	/**
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}
	/**
	 * @return the numStudents
	 */
	public int getNumStudents() {
		return numStudents;
	}
	/**
	 * @param numStudents the numStudents to set
	 */
	public void setNumStudents(int numStudents) {
		this.numStudents = numStudents;
	}
	/**
	 * @return the percentFemale
	 */
	public double getPercentFemale() {
		return percentFemale;
	}
	/**
	 * @param percentFemale the percentFemale to set
	 */
	public void setPercentFemale(double percentFemale) {
		this.percentFemale = percentFemale;
	}
	/**
	 * @return the sATVerb
	 */
	public double getSATVerb() {
		return SATVerb;
	}
	/**
	 * @param sATVerb the sATVerb to set
	 */
	public void setSATVerb(double sATVerb) {
		SATVerb = sATVerb;
	}
	/**
	 * @return the sATMath
	 */
	public double getSATMath() {
		return SATMath;
	}
	/**
	 * @param sATMath the sATMath to set
	 */
	public void setSATMath(double sATMath) {
		SATMath = sATMath;
	}
	/**
	 * @return the expenses
	 */
	public double getExpenses() {
		return expenses;
	}
	/**
	 * @param expenses the expenses to set
	 */
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}
	/**
	 * @return the percentFinancialAid
	 */
	public double getPercentFinancialAid() {
		return percentFinancialAid;
	}
	/**
	 * @param percentFinancialAid the percentFinancialAid to set
	 */
	public void setPercentFinancialAid(double percentFinancialAid) {
		this.percentFinancialAid = percentFinancialAid;
	}
	/**
	 * @return the numberOfApplicants
	 */
	public int getNumberOfApplicants() {
		return numberOfApplicants;
	}
	/**
	 * @param numberOfApplicants the numberOfApplicants to set
	 */
	public void setNumberOfApplicants(int numberOfApplicants) {
		this.numberOfApplicants = numberOfApplicants;
	}
	/**
	 * @return the percentAdmitted
	 */
	public double getPercentAdmitted() {
		return percentAdmitted;
	}
	/**
	 * @param percentAdmitted the percentAdmitted to set
	 */
	public void setPercentAdmitted(double percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}
	/**
	 * @return the percentEnrolled
	 */
	public double getPercentEnrolled() {
		return percentEnrolled;
	}
	/**
	 * @param percentEnrolled the percentEnrolled to set
	 */
	public void setPercentEnrolled(double percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}
	/**
	 * @return the academicsScale
	 */
	public int getAcademicsScale() {
		return academicsScale;
	}
	/**
	 * @param academicsScale the academicsScale to set
	 */
	public void setAcademicsScale(int academicsScale) {
		this.academicsScale = academicsScale;
	}
	/**
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}
	/**
	 * @param socialScale the socialScale to set
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}
	/**
	 * @return the qualityOfLifeScale
	 */
	public int getQualityOfLifeScale() {
		return qualityOfLifeScale;
	}
	/**
	 * @param qualityOfLifeScale the qualityOfLifeScale to set
	 */
	public void setQualityOfLifeScale(int qualityOfLifeScale) {
		this.qualityOfLifeScale = qualityOfLifeScale;
	}
	
	/**
	 * @return the emphases
	 */
	public String[] getEmphases() {
		return this.emphases;
	}
	/**
	 * @param emphases the emphases to set
	 */
	public void setEmphases(String[] emphases) {
		this.emphases = emphases;
	}

}
