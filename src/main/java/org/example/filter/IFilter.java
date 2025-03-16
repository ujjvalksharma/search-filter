package org.example.filter;

import org.example.specification.ISpecification;

import java.util.List;

public interface IFilter<T> {
  List<T> filter(List<T> items, ISpecification<T> spec);
}
