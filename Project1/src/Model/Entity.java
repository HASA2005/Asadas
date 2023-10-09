
package Model;


public class Entity {
    
    private int id,legal_ID,telephone ;
    private String name,address,description;
    
    
    public Entity(){}
    
        public Entity(int legal_ID, String name, int telephone, String address, String description){
    
        this.legal_ID = legal_ID;
        this.name = name;
        this.telephone= telephone;
        this.address = address;
        this.description = description;
    }

    
    public Entity(int id, int legal_ID, String name, int telephone, String address, String description){
    
        this.id = id;
        this.legal_ID = legal_ID;
        this.name = name;
        this.telephone= telephone;
        this.address = address;
        this.description = description;
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
     * @return the legal_ID
     */
    public int getLegal_ID() {
        return legal_ID;
    }

    /**
     * @param legal_ID the legal_ID to set
     */
    public void setLegal_ID(int legal_ID) {
        this.legal_ID = legal_ID;
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
     * @return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
