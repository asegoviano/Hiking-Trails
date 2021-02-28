package com.ht.data;

/**
 * Angel Segoviano 
 * 2/20/2021
 * BookmarkDAOInterface
 */

import java.util.List;
import com.ht.data.entity.EventEntity;

public interface EventDAOInterface<T> {

    public EventEntity create(T t);

    public List<EventEntity> findAllEvents();

    public List<EventEntity> findUserEvent();

    public boolean updateEvent(EventEntity event);

    public boolean delete(String id);
}
