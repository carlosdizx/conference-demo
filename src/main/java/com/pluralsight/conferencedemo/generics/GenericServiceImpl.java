package com.pluralsight.conferencedemo.generics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<Entity, ID extends Serializable> implements GenericServiceApi<Entity, ID> {
    @Override
    @Transactional
    public Entity save(Entity entity) {
        return getDao().save(entity);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Entity findByID(ID id) {
        final Optional<Entity> optionalT = getDao().findById(id);
        return optionalT.isPresent() ? optionalT.get() : null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Entity> getAll() {
        final List<Entity> list = new ArrayList<>();
        getDao().findAll().forEach(list::add);
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Entity> getAll(Pageable pageable) {
        return getDao().findAll(pageable);
    }

    public abstract JpaRepository<Entity, ID> getDao();

}
