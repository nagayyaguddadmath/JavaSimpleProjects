NOTE: this application has been built in JAVA 1 and maven build

To execute this application:

1) Please get the files from the git content https://github.com/nagayyaguddadmath/JavaSimpleProjects/tree/master/quote
2) Open console and execute below command in the fodler "quote"

java -cp quote.jar com.MainApplication "<<Path of the market CSV file (give full absoulute path)>>" <<amount>>

How it will calculate interest:
1) Sorts all lenders by low interest and then high amount
2) Calculates mean interest rate by giving waightage to the amount each lender is giving
3) Calculates yearly factor using formula =  (1-(1+r)^-n)/r
4) Display the calculted amount

It has both positive and negative test cases