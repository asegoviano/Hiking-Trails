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

    public List<Trail> getAllTrail();

    public Trail findById(String id);

}
