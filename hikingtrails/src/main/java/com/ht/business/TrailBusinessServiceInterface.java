/**
 * Angel Segoviano 
 * 1/31/2021
 * TrailBusinessServiceInterface 
 * 
 */
package com.ht.business;

import java.util.List;
import com.ht.model.Trail;

public interface TrailBusinessServiceInterface {

    public List<Trail> getAllTrail();

    public Trail findById(String id);

}
