package org.example.specification;

public interface ISpecification<T> {
   boolean isSatisfiedBy(T item);

   default ISpecification<T> and(ISpecification<T> other) {
      return item -> this.isSatisfiedBy(item) && other.isSatisfiedBy(item); //recursion
   }

   default ISpecification<T> or(ISpecification<T> other) {
      return item -> this.isSatisfiedBy(item) || other.isSatisfiedBy(item); //recursion
   }

   default ISpecification<T> not(ISpecification<T> other) {
      return item -> this.isSatisfiedBy(item); //recursion
   }


}
