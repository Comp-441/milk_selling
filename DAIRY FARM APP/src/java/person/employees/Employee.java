package person.employees;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import person.employees.designation.Designation;
import person.Person;
import production.sales.Sales;
import reports.ProductionReport.ProductionReport;
import reports.SalesReport.SalesDao;
import reports.SalesReport.SalesDaoImpl;

public abstract class Employee extends Person{

    private Date dateOfBirth;
    private int empId;
    private String password;
    private Designation designation;

    public Employee() {
    }

    
    public Employee(int empID) {
       this.empId= empID;
    }

    /**
     *
     * @param dateOfBirth
     * @param empId
     * @param password
     */

    public Employee(Date dateOfBirth, int empId, String password, String firstName, String secondName, String phoneNumber) {
        super(firstName, secondName, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.empId = empId;
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


    public  void login(Employee employee){
    
    }

    public  void viewProductionReport(){
        ProductionReport report = new ProductionReport();
        
    }
    
     public  List<Sales> viewSalesReport(Date date_from){
         SalesDao dao=new SalesDaoImpl();
        
         return dao.viewSales(date_from);
    }
}
