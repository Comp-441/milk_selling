/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package production.cow;

/**
 *
 * @author root
 */
public class Cow {
   private String id;
   private String username;

    public Cow(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public Cow() {
        this.id="";
        this.username="";
    }

    public Cow(String id) {
        this.id = id;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
    
}
