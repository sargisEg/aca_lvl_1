package com.aca.exam.exam2;

import com.aca.exam.exam2.annotations.Nullable;

import java.util.List;

public interface CrudRepository<ENTITY, ID> {

    @Nullable
    ENTITY findById(ID id);

    List<ENTITY> findAll();
}
