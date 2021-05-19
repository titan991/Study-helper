package com.studyhelper.service.common;

import com.studyhelper.entity.models.common.BaseIdEntity;
import com.studyhelper.exceptions.ResponseException;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CrudService<E extends BaseIdEntity, F> {
  default List<E> findAll() {
    throw new ResponseException(HttpStatus.NOT_IMPLEMENTED);
  }

  default E findByIdNN(Long id) {
    throw new ResponseException(HttpStatus.NOT_IMPLEMENTED);
  }

  default Long create(F form) {
    throw new ResponseException(HttpStatus.NOT_IMPLEMENTED);
  }

  default Long update(F form) {
    throw new ResponseException(HttpStatus.NOT_IMPLEMENTED);
  }

  default void deleteById(Long id) {
    throw new ResponseException(HttpStatus.NOT_IMPLEMENTED);
  }
}
