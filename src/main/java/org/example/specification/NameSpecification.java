package org.example.specification;

import org.example.entity.File;

public class NameSpecification implements ISpecification<File> {
  String name;
  public NameSpecification(String name) {
    this.name = name;
  }
  @Override
  public boolean isSatisfiedBy(File file) {
    return file.getName().contains(name);
  }
}
