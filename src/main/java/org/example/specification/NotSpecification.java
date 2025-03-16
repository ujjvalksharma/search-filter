package org.example.specification;

import org.example.entity.File;

public class NotSpecification implements ISpecification<File> {

  ISpecification spec;

  public NotSpecification(ISpecification spec) {
    this.spec = spec;
  }
  @Override
  public boolean isSatisfiedBy(File candidate) {
    return !spec.isSatisfiedBy(candidate);
  }
}
