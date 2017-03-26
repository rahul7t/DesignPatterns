

#Compilation
From the folder: john_doe\registrationScheduler\src

ant all
ant prepare

TO RUN:
From the folder: john_doe\registrationScheduler\src

ant run -Darg0=<reg-preference-file-name> -Darg0=<add-drop-file-name> -Darg1=<outputfilename> -Darg2=<number-of-threads> -Darg3=<logger level>

Example:
ant run -Darg0=reg-input.txt -Darg1=add-drop.txt -Darg2=output.txt -Darg3=2 -Darg4=0

The files are read/written from/to here:
	john_doe/registrationScheduler/reg-input.txt
	john_doe/registrationScheduler/add-drop.txt
	john_doe/registrationScheduler/output.txt
will run 2 threads
will use Logger for debug level 0

CHOICE OF DATA STRUCTURE:
Data structure used is ... because the frequent operations are ... and the time complexity for avg case is ...


Citations:
1.
2.

