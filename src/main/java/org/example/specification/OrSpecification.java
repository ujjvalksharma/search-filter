package org.example.specification;

import org.example.entity.File;

public class OrSpecification implements ISpecification<File>{
  ISpecification left;
  ISpecification right;

  public OrSpecification(ISpecification left, ISpecification right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public boolean isSatisfiedBy(File candidate) {
    return left.isSatisfiedBy(candidate) || right.isSatisfiedBy(candidate);
  }
}
