/**
 * Angel Segoviano 
 * 1/31/2021
 * TrailDAOInterface
 * 
 */
package com.ht.data;

import java.util.List;
import com.ht.data.entity.TrailEntity;

public interface TrailDAOInterface<T> {

    /**
     * method used to return list of all trails
     * 
     * @return arraylist of trails
     */
    public List<TrailEntity> findAll();

    public TrailEntity findById(String id);
}
