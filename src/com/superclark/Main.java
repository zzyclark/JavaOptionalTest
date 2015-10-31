package com.superclark;

import com.superclark.model.Document;
import com.superclark.model.User;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Document docWithNullProperty = new Document("Null property", null);
        Document nullDocument = null;
        User normalUser = new User("Clark", docWithNullProperty);
        /**
         * Create option
         * 1. empty option.
         * 2. option created from non-null object.
         * 3. option created from object that maybe null.
         */
        // empty option
        Optional<String> emptyOption = Optional.empty();

        // This will throw NullPointerException, we must confirm the object we pass is a non-null object
        Optional<Document> docNonNullOption = Optional.of(nullDocument);

        //This allow null object passed in
        Optional<Document> docNullableOption = Optional.ofNullable(docWithNullProperty);

        /**
         * Get option
         * We can get option from each option we create
         */

        // This will throw NoSuchElementException, since this is an empty option
        String nullString = emptyOption.get();

        //This will give us docWithNullProperty
        Document nonNullDocument = docNullableOption.get();

        /**
         * Check present
         */

        //use isPresent to check condition
        if (docNullableOption.isPresent()) {
            // content will be null, since we didn't check whether inside document all the property is non-null value.
            printVal(docNullableOption.get());
        }

        //user ifPresent to consume some certain logic
        docNullableOption.ifPresent(d -> printVal(d));

        /**
         * we can filter the result by option filter
         */

        //only get document which has title contains char t
        docNullableOption.filter(d -> d.getTitle().contains("t"))
                .ifPresent(d -> printVal(d));

        /**
         * map and flatMap is used to transform object
         */

        //get document title option
        Optional<String> docTitleOption = docNullableOption.map(Document::getTitle);

        //difference between this one and map is that getContentOption directly return option, while getTitle just return normal Object
        Optional<String> docContentOption = docNullableOption.flatMap(Document::getContentOption);

        /**
         * orElse, orElseGet, orElseThrow returns alternative result once the option is empty
         */

        //if option is empty return something else
        String documentTitle = docNullableOption.map(Document::getTitle).orElse("Empty Title");

        //if option is empty do something else
        String documentContent = docNullableOption.flatMap(Document::getContentOption).orElseGet(() -> defaultContent());

        //if option is empty throw certain exception, you can change to your own exception here
        documentContent = docNullableOption.flatMap(Document::getContentOption).orElseThrow(NoSuchElementException::new);
    }

    private static void printVal(Object obj) {
        System.out.println(obj.toString());
    }

    private static String defaultContent() {
        return "Empty Content";
    }
}
