# CS542 Design Patterns
## Spring 2017
## ASSIGNMENT 3 README FILE
## Goal: Replicate spreadsheet dependent cell update feature using **Observer pattern**

## command to untar
tar -zxvf rahul_thosar_assign_3.tar.gz 

Assuming you are in the directory rahul_thosar_assign_3\spreadsheetUpdates:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all
or as specified on assignment page
ant -buildfile src/build.xml -Darg0=input.txt -Darg1=output.txt -Darg2=0


-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code

ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=0


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

[Date: 4/2/2017]

-----------------------------------------------------------------------

## Justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)
```
For this assignment, I chose an arraylist of cells object.
Since most of my code does add and remove from list, It provided speed in adding and removing the object observers
The time complexity for add is O(1), get is O(1) and remove is O(n)
Student object contains all the necessary details like reg time, preferences and score.
Vectors grow in size 50%, hence they are easy on utilizing space
```

Algorithm used to detect cycle:
I have maintaind two lists, one of subjects and one of observers.

Before adding any observer into observer list of that subject, we first check if 
subject is present inthe observer list of the observer (as the observer can also be he subject)

Eg: we have the following lines which is a cycle,
b1=a1+77 (a1's observerList contains b1)
a1=b1+84
(If  above line is added, it will mean that, b1's observer list contains a1, causing a cycle, hence reject line)
use recursion to detect multiple level algo.

-----------------------------------------------------------------------

## Code references
(if any).
Reading file:
http://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java

writing file:
https://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/

isnumeric:
http://stackoverflow.com/questions/14206768/how-to-check-if-a-string-is-numeric