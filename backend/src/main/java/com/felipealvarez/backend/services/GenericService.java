package com.felipealvarez.backend.services;

public interface GenericService <T,ID>{
  public T save(T entity) throws Exception;
  public T update(T entity) throws Exception;
}
