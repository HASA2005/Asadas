
package Model;

/**
 *
 * @author Cliente
 */
public class District {
    private int id;
    private String name;
    private String canton_id;
    
    public District(){}
    
    
    public District(int id, String name, String canton_id){
        this.id = id;
        this.name = name;
        this.canton_id = canton_id;
    
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
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
     * @return the canton_id
     */
    public String getCanton_id() {
        return canton_id;
    }

    /**
     * @param canton_id the canton_id to set
     */
    public void setCanton_id(String canton_id) {
        this.canton_id = canton_id;
    }
    
    
}
