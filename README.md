# Noodles-ordering-and-management-system
This is my group assignment when I was studying software engineering in my junior year.


HELP TO USE:
STEP 1：
Go to this website: https://gluonhq.com/products/javafx/

Download JavaFX Windows SDK

[This One!!!!]Click download!!!
Product			Public version	LTS version	Platform	Download
JavaFX Windows SDK	11.0.2		11.0.7 More info	Windows	Download 

If you can't download the javafx sdk at this website. You can download it from the following link.
Link：https://pan.baidu.com/s/1H8XDpIPSIRqjBiG2OBO1Ww 
Code：ytni

If you still have problem, please send email to wjj991019@bupt.edu.cn

STEP 2(This is really important!):
Unzip the file javafx-sdk-11.0.2.zip. Please choose "Unzip to javafx-sdk-11.0.2". 

Move the directory javafx-sdk-11.0.2 under xxx\RamenGo\lib.

You should make sure the directory structure is as followed.
-RamenGo
  -lib
    -javafx-sdk-11.0.2
        -lib
        -bin
        -legal
  -src

If you make a wrong structure, you can't run the program!!!!!

If you have problem, please send email to wjj991019@bupt.edu.cn

STEP 3:
Open the command line and go to the xxx\RamenGo\src dirctory

Make sure you are under the src directory.

STEP 4:
First find the path of  xxx\RamenGo\lib\javafx-sdk-11.0.2\lib.
For example,  C:\Users\wjj99\Documents\RamenGo\lib\javafx-sdk-11.0.2\lib.

Then,please execute the commands  below:
xxx\src>	javac --module-path  xxx\RamenGo\lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml,javafx.graphics control/*.java entities/*.java boundary/*.java *.java
please replace xxx\RamenGo\lib\javafx-sdk-11.0.2\lib with the actual path.

For example, javac --module-path C:\Users\wjj99\Documents\RamenGo\lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml,javafx.graphics control/*.java entities/*.java boundary/*.java *.java

STEP 5:
Enter the command:
xxx\src>	javac --module-path C:\Users\wjj99\Documents\RamenGo\lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml,javafx.graphics FakeMain

please replace xxx\RamenGo\lib\javafx-sdk-11.0.2\lib with the actual path.

For example, java --module-path C:\Users\wjj99\Documents\RamenGo\lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml,javafx.graphics FakeMain


=======================================================
Then finally, enjoy your time.


#########Annotation
javac --module-path C:\Users\wjj99\Documents\RamenGo\lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml,javafx.graphics control/*.java entities/*.java boundary/*.java *.java

java --module-path C:\Users\wjj99\Documents\RamenGo\lib\javafx-sdk-11.0.2\lib --add-modules javafx.controls,javafx.fxml,javafx.graphics FakeMain
