package person.employees;

import database.Database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import person.employees.designation.Designation;
import person.Person;

public abstract class Employee extends Person{

    private Date dateOfBirth;
    private int empId;
    private String password;
    private Designation designation;

    public Employee() {
        this.dateOfBirth=new Date(System.currentTimeMillis());
        this.empId=0;
        this.designation=Designation.Clerk;
        this.password="passCode";
    }

    public Employee(String firstName, String secondName) {
        super(firstName, secondName);
    }
    

    
    public Employee(int empID) {
       this.empId= empID;
    }

    public Employee(int empId, String password) {
        this.empId = empId;
        this.password = password;
    }
    
    

    /**
     *
     * @param dateOfBirth
     * @param secondName
     * @param phoneNumber
     * @param firstName 
     * @param password
     */

    public Employee(Date dateOfBirth, String password, String firstName, String secondName, String phoneNumber) {
        super(firstName, secondName, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }
    
    

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }


    public  boolean login(){
                    
        try {
            //Process login
            Database database=new Database();
            
            //Query
            String query= "SELECT * from employee where emp_id=? and password=? and designation=?";
            
            PreparedStatement statement=database.getPreparedStatement(query);
            
            //give prepared statements parameters
            statement.setInt(1, this.getEmpId());
            statement.setString(2, this.password);
            statement.setString(3, this.designation.toString());
            
                                  
            
           
           ResultSet resultSet= database.retrieveInfo(statement);
            
            
            if(resultSet.next()){
            this.setFirstName(resultSet.getString(2));
            this.setSecondName(resultSet.getString(3));
            
            return true;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    
    }
}
