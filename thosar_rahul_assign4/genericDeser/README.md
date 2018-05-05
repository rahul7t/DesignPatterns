# CS542 Design Patterns
## Spring 2017
## ASSIGNMENT 4 README FILE
## Goal: Deserialize custom markup language from file, create objects using **Java reflection** and count instances.

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all
or as specified on assignment page
ant -buildfile src/build.xml -Darg0=reg-preference.txt -Darg1=add-drop.txt -Darg2=output.txt -Darg3=1 -Darg4=1


-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code

ant -buildfile src/build.xml run -Darg0=reg-preference.txt -Darg1=add-drop.txt -Darg2=output.txt -Darg3=1 -Darg4=1


-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 3/7/2017]

-----------------------------------------------------------------------

## Justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)
```
For this assignment, a vector of student object was used to handle the data.
This is because vectors are thread safe
The time complexity for add is O(1), get is O(1) and remove is O(n)
Student object contains all the necessary details like reg time, preferences and score.
Vectors grow in size by double.
```

## Code references
(if any).
Reading file:
http://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java

writing file:
https://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
