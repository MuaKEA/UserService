package com.md.demo.crud;

import com.md.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface iUserCrud extends CrudRepository<User,Long> {
}
