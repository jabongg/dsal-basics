package com.learning.java.annotations;

@Author(name = "benjamin", date = "28/02/2021")
@SuppressWarnings(value="")


@ClassPreamble (
		   author = "John Doe",
		   date = "3/17/2002",
		   currentRevision = 6,
		   lastModified = "4/12/2004",
		   lastModifiedBy = "Jane Doe",
		   // Note array notation
		   reviewers = {"Alice", "Bob", "Cindy"}
		)
public class MyAnnotation {

}
