/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports.SalesReport;

import java.sql.Date;
import java.util.List;
import production.sales.Sales;

/**
 *
 * @author thucheiz
 */
public interface SalesDao {
    
    public List<Sales> viewSales(Date date_from);
    
}
