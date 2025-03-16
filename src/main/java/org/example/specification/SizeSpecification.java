package org.example.specification;

import org.example.entity.File;

public class SizeSpecification implements ISpecification<File>{
  int minSize;
  int maxSize;
  public SizeSpecification(int minsize, int maxSize) {
    this.minSize = minsize;
    this.maxSize = maxSize;
  }


  @Override
  public boolean isSatisfiedBy(File file) {
    return file.getSize() >= minSize && file.getSize() <= maxSize;
  }
}
