package org.example.specification;

import org.example.entity.File;

public class AndSpecification implements ISpecification<File>{
  ISpecification left;
  ISpecification right;

  public AndSpecification(ISpecification<File> left, ISpecification<File> right) {
    this.left = left;
    this.right = right;
  }
  @Override
  public boolean isSatisfiedBy(File candidate) {
    return left.isSatisfiedBy(candidate) && right.isSatisfiedBy(candidate);
  }
}
