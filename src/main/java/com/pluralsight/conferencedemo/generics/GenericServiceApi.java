package com.pluralsight.conferencedemo.generics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceApi<Entity, ID extends Serializable> {
    Entity save(Entity entity);

    void delete(ID id);

    Entity findByID(ID id);

    List<Entity> getAll();

    Page<Entity> getAll(Pageable pageable);
}
