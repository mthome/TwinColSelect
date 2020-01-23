# TwinColSelect

Vaadin 14 Java version of TwinColSelect

TwinColSelect component, also known as list builder. It is a component for multiselection.

This is component consists of two lists. You can move items from the other list to other. The left list is
master list and backed by DataProvider. The right list is the selection list and reflects the value of the
selection.
 
 The component also has drag and drop support.

## Release notes

### Version 1.1.0

- Small fixes, added some JavaDocs added Drag and Drop support
- Vaadin 14.1 or newer required

### Version 1.0.0

- The first release 

## Development instructions

Starting the test/demo server:
1. Run `mvn jetty:run`.
2. Open http://localhost:8080 in the browser.

## Publishing to Vaadin Directory

You can create the zip package needed for [Vaadin Directory](https://vaadin.com/directory/) using
```
mvn versions:set -DnewVersion=1.0.0 # You cannot publish snapshot versions 
mvn install -Pdirectory
```

The package is created as `target/twincolselect-1.0.0.zip`

For more information or to upload the package, visit https://vaadin.com/directory/my-components?uploadNewComponent