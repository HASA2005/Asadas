
package Model;

import java.util.Date;


public class FlowMeasurement {
    private int id,rising_id ,samplingsite_id ;
    private String method,capacity, observation,weather ;
    private Date date;
    
    public FlowMeasurement(){}
    
    
      public FlowMeasurement(String method,String capacity, String observation, Date date, String weather, int rising_id, int samplingsite_id){
    

        this.method = method;
        this.capacity = capacity;
        this.observation = observation;
        this.date = date;
        this.weather = weather;
        this.rising_id = rising_id;
        this.samplingsite_id = samplingsite_id;
    }

    public FlowMeasurement(int id,String method,String capacity, String observation, Date date, String weather, int rising_id, int samplingsite_id){
    
        this.id = id;
        this.method = method;
        this.capacity = capacity;
        this.observation = observation;
        this.date = date;
        this.weather = weather;
        this.rising_id = rising_id;
        this.samplingsite_id = samplingsite_id;
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
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return the capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the weather
     */
    public String getWeather() {
        return weather;
    }

    /**
     * @param weather the weather to set
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * @return the rising_id
     */
    public int getRising_id() {
        return rising_id;
    }

    /**
     * @param rising_id the rising_id to set
     */
    public void setRising_id(int rising_id) {
        this.rising_id = rising_id;
    }

    /**
     * @return the samplingsite_id
     */
    public int getSamplingsite_id() {
        return samplingsite_id;
    }

    /**
     * @param samplingsite_id the samplingsite_id to set
     */
    public void setSamplingsite_id(int samplingsite_id) {
        this.samplingsite_id = samplingsite_id;
    }
    
}
