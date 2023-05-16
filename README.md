# Lab-6
## Lab 6 Exception Handling Assignment
### Lab 6 dir
### In lab 6 directory you will find the source code as 4 java files, 3 batch files and Input files directory contains files used for test
(
### ***JAVA FILES***
- ***Main.java***: includes the main code and main method that will be run on execution.
- ***Container.java***: contains Container class which is used to parse arxml containers to java.
- ***NotValidAutosarFileException.java***: contains NotValidAutosarException which is triggered on if passed file's extension isn't "**.arxml**".
- ***EmptyAutosarFileException.java***: contains EmptyAutosarFileException  which is triggered on if passed file is empty.

### ***BATCH FILES***
- ***Run Correct File***: on clicked it will generate .class files then it will run the main code which will create a new directory "**called Output Files**" and creates an output file inside it which is the new modified file called Rte_Ecuc_mod.arxml 
- ***Run Empty File***: on clicked it will generate .class files then will run the main code which will trigger **EmptyAutosarFileException**
- ***Run wrong extension File***: on clicked it will generate .class files then will run the main code which will trigger **NotValidAutosarFileException**
