package org.example.filter;

import org.example.entity.File;
import org.example.specification.ISpecification;

import java.util.List;
import java.util.stream.Collectors;

public class Filter<T> implements IFilter<T> {

  @Override
  public List<T> filter(List<T> items, ISpecification<T> spec) {
    return items.stream().filter(item -> spec.isSatisfiedBy(item)).collect(Collectors.toList());
  }
}
