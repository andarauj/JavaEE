/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demos.client;



import demos.db.Products;
import demos.model.ProductsManager;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.OptimisticLockException;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author Andre
 */


public class ProductsClient {
    
    private static final Logger logger = Logger.getLogger(ProductsClient.class.getName());
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            ProductsManager pm = new ProductsManager("ProductClientPU");
            
            //Products p = pm.findProduct(1);
            //System.out.println(p);
            
            //List<Products> products = pm.findProductByName("Co%");
            //products.stream().forEach(p -> System.out.println(p));
            
            //Products p = pm.findProduct(1);
            //p.setPrice(BigDecimal.valueOf(2.5));
            //p.setBestBefore(LocalDate.now().plusDays(1));
            //pm.update(p);
            
            //Products p = pm.findProduct(1);
            //p.setPrice(BigDecimal.valueOf(0.1));
            //p.setName("x");
            //p.setBestBefore(LocalDate.now().plusDays(1));
            //pm.update(p);

            Products p = pm.findProduct(1);
            p.setPrice(BigDecimal.valueOf(5));
            Scanner s = new Scanner(System.in);
            System.out.println("Click here and then press enter to continue");
            s.nextLine();
            pm.update(p);
            
            
            pm.closeEntityManager();
    
}
    catch (Exception ex) {
    Throwable cause = ex.getCause();
    
    if (cause instanceof ConstraintViolationException) {
       ConstraintViolationException e =
               (ConstraintViolationException) cause;
       e.getConstraintViolations().stream()
               .forEach(v -> logger.log(Level.INFO,v.getMessage()));
               
    } else if (cause instanceof OptimisticLockException) {
        OptimisticLockException e = (OptimisticLockException)cause;
        logger.log(Level.INFO, e.getMessage());
    }else {
        logger.log(Level.SEVERE, "Product Manager Error",ex);
        
    }
    
}
    }
    
    
}
