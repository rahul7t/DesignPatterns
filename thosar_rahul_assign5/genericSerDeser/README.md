# CS542 Design Patterns
## Spring 2017
## ASSIGNMENT 5 README FILE
## Goal: Comparing Objects in Java

## command to untar
tar -zxvf thosar_rahul_assign5.tar.gz 

Assuming you are in the directory thosar_rahul_assign5\genericSerDeser:

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
NOTE: Please Keep the input.txt beside src folder, ie, where README.txt is located.


format:
ant -buildfile src/build.xml run -Darg0=<input file name> -Darg1=<output file name> -Darg2=<DEBUG_VALUE from 0 - 4>
example:
ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=0

----------------------------------------------------------------------
Logger level explained:
0 - Nothing printed, except "output.txt File created" for a confirmation that program ended. For long input files, it took time to run,
	so as a assurance to user, a confirmation message was displayed
1 - Displays the output that will be displayed in output.txt
2 - Displays the objects added to first second object list
3 - Displays everytime the serdeser and createDPMLFormat function is called
4 - Displays everytime a constructor is called
----------------------------------------------------------------------
Commits:
https://bitbucket.org/csx42spring2017/thosar_rahul_assign5/commits/all
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

[Date: 5/9/2017]

-----------------------------------------------------------------------

## Justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)
```
For this assignment, I chose an ArrayList to store my first and second object.
Majority of my logic requires addition and retreiving on objects (sometimes duplicate) in lists.
ArrayList provides appropriate api to perform such operation quickly. 
ArrayList allow to store duplicate objects and also maintain insertion order.
The time complexity for add is O(1), get is O(1)
```
ArrayList have Space Complexity of O(n), and doubles in size when full


-----------------------------------------------------------------------

## Code References
(if any).
Reading file:
http://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java