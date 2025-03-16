package org.example;

import org.example.entity.File;
import org.example.filter.Filter;
import org.example.filter.IFilter;
import org.example.specification.ISpecification;
import org.example.specification.NameSpecification;
import org.example.specification.NotSpecification;
import org.example.specification.OrSpecification;
import org.example.specification.SizeSpecification;

import java.util.List;

public class Driver {
  public static void main(String[] args) {

    List<File> files =  List.of(
            new File("salary.pdf", 100),
            new File("dog.png", 1000),
            new File("cat.jpeg", 2000),
            new File("animal.png", 20)
    );

    ISpecification nameSpec = new NameSpecification("dog");
    ISpecification extension = new NameSpecification(".png");

    IFilter<File> fileFilter = new Filter();
    List<File> filteredFiles = fileFilter.filter(files, nameSpec);
    System.out.println("filteredFiles: " + filteredFiles);

    ISpecification notSpec = new NotSpecification(nameSpec);

    List<File> notfilteredFiles = fileFilter.filter(files, notSpec);
    System.out.println("notfilteredFiles: " + notfilteredFiles);


    ISpecification sizeSpec = new SizeSpecification(1000, 10000);
    // Create an OR specification: file name contains "report" OR is not "presentation.pptx".
    ISpecification<File> orSpec = new OrSpecification(nameSpec, sizeSpec);
    // Filter files with the OR specification.
    List<File> orFilteredFiles = fileFilter.filter(files, orSpec);
    System.out.println("orFilteredFiles: " + notfilteredFiles);

    ISpecification combinedSpec = nameSpec.and(sizeSpec).and(extension);
    List<File> combinedSpecFiles = fileFilter.filter(files, combinedSpec);
    System.out.println("combinedSpecFiles: " + combinedSpecFiles);
  }
}