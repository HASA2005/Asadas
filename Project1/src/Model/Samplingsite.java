/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Cliente
 */
public class Samplingsite {
     
    private int id;
    private String name;
    private String province_id;
    private String district_id;
    private String canton_id;
    private String entity_id;
            
 public Samplingsite(){}
 
 
  
 public Samplingsite(String name, String province_id, String district_id, String canton_id, String entity_id){

     this.name = name;
     this.province_id = province_id;
     this.district_id = district_id;
     this.canton_id = canton_id;
     this.entity_id = entity_id;
       
 }
 
 
 public Samplingsite(int id, String name, String province_id, String district_id, String canton_id, String entity_id){
 
     this.id = id;
     this.name = name;
     this.province_id = province_id;
     this.district_id = district_id;
     this.canton_id = canton_id;
     this.entity_id = entity_id;
       
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
  
 
 
}
