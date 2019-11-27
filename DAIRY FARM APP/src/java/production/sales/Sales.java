package production.sales;

import java.sql.Date;
import person.employees.Clerk;
import production.produce.MilkProduced;

public class Sales {

    private Date   dateProduced;
    private MilkProduced produced;
    private String saleId;
    private double quantity;
    private Clerk clerk;

    public Sales(){
        this.clerk=new Clerk();
        this.dateProduced=new Date(System.currentTimeMillis());
        this.saleId="S-1";
        this.quantity=0.00;
        this.produced=new MilkProduced();
    }

    public Sales(Date dateProduced, MilkProduced produced, String saleId, double quantity) {
        this.dateProduced = dateProduced;
        this.produced = produced;
        this.saleId = saleId;
        this.quantity = quantity;
    }

    public MilkProduced getProduced() {
        return produced;
    }

    public void setProduced(MilkProduced produced) {
        this.produced = produced;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Date getDateProduced() {
        return dateProduced;
    }

    public void setDateProduced(Date dateProduced) {
        this.dateProduced = dateProduced;
    }


    public MilkProduced getProduction() {
        return this.produced;
    }

    public void setProduction(MilkProduced milkProduced) {
        this.produced = milkProduced;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    
    
}
