package production.sales;

import java.sql.Date;
import production.produce.MilkProduced;

public class Sales {

    private Date   dateProduced;
    private MilkProduced produced;
    private String saleId;
    private double quantity;

    public Sales(){}

    public Sales(Date dateProduced, MilkProduced produced, String saleId, double quantity) {
        this.dateProduced = dateProduced;
//        this.customerId = customerId;
        this.produced = produced;
        this.saleId = saleId;
        this.quantity = quantity;
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
