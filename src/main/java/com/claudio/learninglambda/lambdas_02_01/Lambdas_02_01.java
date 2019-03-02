package com.claudio.learninglambda.lambdas_02_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Lambdas_02_01
 */
public class Lambdas_02_01 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Claudio", "Rafaela", "Vitor", 
            "Carla", "Amanda", "Bruno");
        
        // 1 - way to sor prior to java 8 lambdas
        Collections.sort(names, new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        // 2 - first iteration with lambda
        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });

        // 3 - now remove the return statement
        Collections.sort(names, (String a, String b) -> b.compareTo(a));

        // 4 - now remove the data types and allow the compiler to infer the type 
        Collections.sort(names, (a,b) -> b.compareTo(a));

        //total pages in your book collection
        Book book1 = new Book("Miss Peregrine's Home for Peculiar Children",
                "Ranson", "Riggs", 382);
        Book book2 = new Book("Harry Potter and The Sorcerers Stone",
                "JK", "Rowling", 411);
        Book book3 = new Book("The Cat in the Hat",
                "Dr", "Seuss", 45);

        List<Book> books = Arrays.asList(book1, book2, book3);

        int total = books.stream().collect(Collectors.summingInt(Book::getPages));

        System.out.println("Total de páginas "+total);

        //create a list with duplicates
        List<Book> dupBooks = Arrays.asList(book1, book2, book3, book1, book2);
        System.out.println("Before removing duplicates");
        System.out.println(dupBooks.toString());

        Collection<Book> noDups = new HashSet<>(dupBooks);
        System.out.println("After removing duplicates");
        System.out.println(noDups.toString());

        //aggregate author first names into a list
        List<String> list = books.stream()
            .map(Book::getAuthorFName)
            .collect(Collectors.toList());
        System.out.println(list);

        //aggregate author first names into a list from dupBooks
        List<String> dupList = dupBooks.stream()
            .map(Book::getAuthorFName)
            .collect(Collectors.toList());
        System.out.println(dupList);

        //example of using Set to eliminate dups and sort automatically
        Set<Integer> numbers = new HashSet<>(Arrays.asList(4,3,3,3,2,1,1,1));
        System.out.println(numbers.toString());
    }
    
}