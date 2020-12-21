package com.md.demo.crud;

import com.md.demo.model.Zipcode;
import org.springframework.data.repository.CrudRepository;

public interface iZipcodeCrud extends CrudRepository<Zipcode,Long> {
}
