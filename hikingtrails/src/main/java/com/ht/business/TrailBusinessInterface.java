/**
 * Angel Segoviano 
 * 1/31/2021
 * TrailBusinessInterface 
 * 
 */
package com.ht.business;

import java.util.List;
import com.ht.model.Trail;

public interface TrailBusinessInterface {

    /**
     * 
     * @return a list of all TrailEntity instances
     */
    public List<Trail> getAllTrail();

    /**
     * finds the specified trail
     * 
     * @param id
     * @return the result of the specefied trail
     */
    public Trail findById(String id);

}
