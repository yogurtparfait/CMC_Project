import dblibrary.project.csci230.*;
import java.io.*;
import java.util.*;

/** 
 * To run, issue: java DBLibraryDriver "YourDatabaseName" "YourDatabaseUsername" "YourDatabasePassword" 
 * in the Interactions Pane in Dr. Java
 * 
 * Output will be saved to a comman-separated file called output.csv which you may open using a text editor or
 * a spreadsheet
 */ 

public class DBLibraryDriver {
  private UniversityDBLibrary univDBlib;
  
  public  DBLibraryDriver(String db, String username, String password){
    univDBlib = new UniversityDBLibrary(db,username,password);
  }
  
  public UniversityDBLibrary getUnivDBlib(){
    return univDBlib;
  }
  
  public void display(String[][] table, PrintWriter pw, int topx) {
    
    if(table!=null){
      if (topx == -1 || topx > table.length)
        topx = table.length;      
      for (int row = 0; row < topx; row++) {         
        for (int col = 0; col < table[0].length; col++) {
          pw.print(table[row][col] + ",");
        }
        pw.println();
      }     
    }
    else{
      pw.println("Nothing to display");
    }
  }
  
  public static void main(String[] args) {
    try{
      int topx = -1;
      DBLibraryDriver dbld = new DBLibraryDriver(args[0],args[1], args[2]);
      PrintWriter pw = new PrintWriter("output.csv");
      pw.println("******************************************************************");  
      pw.println("Demo user_getUsers():");
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().user_getUsers(),pw,topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo user_addUser(Imad Rahal ImadUser ImadPass a):"+ 
                 dbld.getUnivDBlib().user_addUser("Imad", "Rahal", "ImadUser", "ImadPass", 'a'));
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().user_getUsers(),pw,topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo user_editUser(ImadUser Edited Edited Edited a N):"+
                 dbld.getUnivDBlib().user_editUser("ImadUser", "Edited", "Edited", "Edited", 'a', 'N'));
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().user_getUsers(),pw,topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo university_getUniversities():");
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().university_getUniversities(),pw, topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo university_addUniversity(x x x x 1 1 1 1 1 1 1 1 1 1 1 1)):"+ 
                 dbld.getUnivDBlib().university_addUniversity("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1));
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().university_getUniversities(),pw, topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo university_editUniversity(x y y y 2 2 2 2 2 2 2 2 2 2 2 2):"+ 
                 dbld.getUnivDBlib().university_editUniversity("x","y","y","y",2,2,2,2,2,2,2,2,2,2,2,2));
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().university_getUniversities(),pw, topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo university_getNamesWithEmphases():");
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().university_getNamesWithEmphases(),pw,topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo university_addUniversityEmphasis(x 1224):"+ 
                 dbld.getUnivDBlib().university_addUniversityEmphasis("x","1224"));
      pw.println("Demo university_addUniversityEmphasis(x 1122):"+ 
                 dbld.getUnivDBlib().university_addUniversityEmphasis("x","1122"));
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().university_getNamesWithEmphases(),pw,topx);     
      
      pw.println("******************************************************************");  
      pw.println("Demo university_removeUniversityEmphasis(x 1224):"+
                 dbld.getUnivDBlib().university_removeUniversityEmphasis("x","1224"));
      pw.println("Demo university_removeUniversityEmphasis(x 1122):"+
                 dbld.getUnivDBlib().university_removeUniversityEmphasis("x","1122"));
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().university_getNamesWithEmphases(),pw,topx);    
      
      pw.println("******************************************************************");  
      pw.println("Demo university_getEmphases():");
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().university_getEmphases(),pw,topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo user_getUsernamesWithSavedSchools():"); 
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().user_getUsernamesWithSavedSchools(),pw,topx);
      
      pw.println("******************************************************************");  
      pw.println("Demo user_saveSchool(user_saveSchool(ImadUser BARD):" + 
                 dbld.getUnivDBlib().user_saveSchool("ImadUser","BARD") );
      pw.println("Demo user_saveSchool(user_saveSchool(ImadUser AUBURN):" + 
                 dbld.getUnivDBlib().user_saveSchool("ImadUser","AUBURN") );
      pw.println("Demo user_saveSchool(user_saveSchool(ImadUser BARD):" + 
                 dbld.getUnivDBlib().user_saveSchool("ImadUser","BARD") );       
      pw.println("******************************************************************");  
      
      dbld.display(dbld.getUnivDBlib().user_getUsernamesWithSavedSchools(),pw,topx);
      pw.println("******************************************************************");  
      pw.println("Demo user_removeSchool(ImadUser BARD):"+ 
                 dbld.getUnivDBlib().user_removeSchool("ImadUser","BARD") );
      pw.println("Demo user_removeSchool(ImadUser AUBURN):"+ 
                 dbld.getUnivDBlib().user_removeSchool("ImadUser","AUBURN") );
      pw.println("******************************************************************");  
      dbld.display(dbld.getUnivDBlib().user_getUsernamesWithSavedSchools(),pw,topx);
      
      pw.close();
    }  
    
    catch(FileNotFoundException fnfe){
      fnfe.printStackTrace();
    }
    finally{
      System.out.println("...DONE...");
    }
  }
}
