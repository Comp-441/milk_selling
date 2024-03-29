package production.produce;

import java.io.Serializable;
import java.sql.Date;
import person.employees.Clerk;
import production.cow.Cow;

public class MilkProduced implements Serializable{
    private Date dateAdded;
    private Clerk clerk;
    private Double quantity;
    private String productionId;
    private String remarks;
    private Cow cow;

    public MilkProduced(String productionId){
        this.productionId=productionId;
}

    public MilkProduced() {
        this.clerk=new Clerk();
        this.dateAdded=new Date(System.currentTimeMillis());
        this.quantity=0.00;
        this.productionId="P-1";
        this.remarks="";
        this.cow=new Cow();
    }
    
    

    public MilkProduced(Clerk clerk, Date dateAdded, double quantity, String productionId, String remarks, Cow cow) {
        this.dateAdded = dateAdded;
        this.clerk = clerk;
        this.quantity = quantity;
        this.productionId = productionId;
        this.remarks = remarks;
        this.cow = cow;
    }
    
    
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    


    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Cow getCow() {
        return this.cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }
}
