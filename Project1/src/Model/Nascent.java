
package Model;

/**
 *
 * @author Cliente
 */
public class Nascent {
    private int id;
    private String name;
    private String address;
    private double length;
    private String description;
    private String province_id;
    private String district_id;
    private String entity_id;
    private String canton_id;
    
    public Nascent (){}
    
     public Nascent(String name, String address, double length, String description, String province_id, String district_id, String entity_id, String canton_id ){

        this.name = name;
        this.address = address;
        this.length = length;
        this.description = description;
        this.province_id = province_id;
        this.district_id = district_id;
        this.entity_id = entity_id;
        this.canton_id = canton_id;
    }

    public Nascent(int id, String name, String address, double length, String description, String province_id, String district_id, String entity_id, String canton_id ){
        this.id = id;
        this.name = name;
        this.address = address;
        this.length = length;
        this.description = description;
        this.province_id = province_id;
        this.district_id = district_id;
        this.entity_id = entity_id;
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
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(double length) {
        this.length = length;
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

    /**
     * @return the province_id
     */
    public String getProvince_id() {
        return province_id;
    }

    /**
     * @param province_id the province_id to set
     */
    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    /**
     * @return the district_id
     */
    public String getDistrict_id() {
        return district_id;
    }

    /**
     * @param district_id the district_id to set
     */
    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    /**
     * @return the entity_id
     */
    public String getEntity_id() {
        return entity_id;
    }

    /**
     * @param entity_id the entity_id to set
     */
    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
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

