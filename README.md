                                                                  Introduction

The Student Classification System enables the user to enter the data of the students and based on the details entered the user can form the segments of students belonging to the same category having similar skills. Along with this the user can view the data or can remove a particular student from the record table stored in MySQL database(using jdbc) by entering his/her id in an user interface way made by applying the concept of Java Swing. The segments will  be formed on the features such as test preparation, parental level of education, gender, math score, reading score and writing score. 

Talking about the system, it can also predict among which clusters, those formed above, the new student should lie by having his/her details with the use of implemented Neural Networks Algorithm. 

For classification, the neural network algorithm needs labels of the training data but we initially don’t have any labels. So, with the help of the implemented k-means algorithm we will get the labels as it clusters the data into different segments. After getting the corresponding labels to the features we can train our neural networks which will later classify the cluster for the new record.



       


                                                                  Need of System

To manage enormous amounts of data, it becomes important to include a managing tool. A Student Classification System is a solution to the problem of manually inspecting and classifying data. The Student Classification System is a solution tool that is designed to maintain and segment the data and can be used for predicting the class/segment of the new record.


                                                                  Motivation

Managing an entire database, analyzing and segmenting the students and  classifying the segment for new students can be quite hectic, and chaotic, especially when you are doing it manually. One can only imagine how tough it can be to manually read and analyze the whole database. Working with mountains of data which contains student’s info , scores in various activities , and more is time consuming, requires a great manual effort and can be overwhelming, to say the least. 

The Student Classification System reviews the performances of students with the help of automated reports and analytics. The information access can be done easily as it has efficient control over student data. With the help of the Student Classification System the user does not need to perform the statistics and analysis manually as the system can inspect and examine the data on its own. 

The system holds crucial functions to ensure the management runs smoothly which reduces human labor , paper and workload.

                                                                  Related Work

Researchers had done many projects on the Student Classification System where they made an  application software which is designed to classify the students by using Machine Learning algorithms. Few such researches or systems are “The development of classification system of student final assignment using Naive Bayes Classifier” , “Student Performance analysis system” and “Intelligent Mining and Decision Support System”. The suggested system contains data regarding information of the student and works on different phases like problem and data understanding, system analysis and design, implementation and testing and evaluation of results. These systems analyze performance with data mining and various ML algorithms.

                                                                  Proposed Method

An user interface system that can manage, retrieve and store the data in a MySQL database implemented with the use of jdbc and Java Swing.
The system will have the implementation of k-means algorithm that can form different classes or groups of the stored data based on similarity. After formation of segments we can train our neural network model on students data and the labels that we formed using k-means algorithm for classification of new students.
For the ease we took a pre-made dataset of students which we will use for our algorithm. 


                                                                  Methodology

The project methodology is needed to make sure the project will be developed systematically in order to acquire a better result. We started with the planning of the project and discussed the actions that can help users to group and classify students.
We will start with creating a user interface from where the user can perform various actions such as adding, removing students and viewing the data of the student. The interface will also contain the options for clustering the students and classifying the category of a new student.

Here at first we will design a user interface from where the user will login and can perform the actions for managing the students records , categorizing the students and classifying the cluster for new students by using the concept of Java Swing.

We will store the data that we took in a MySQL database using jdbc(Java Database Connectivity). The system also contains the option for adding more data by which the user can increase the size of samples that are to be clustered. 

Next we will implement the algorithm for grouping the data into different classes. The algorithm that we will use is the k-means clustering algorithm which groups the unlabeled dataset into different clusters. We will categorize students on the features - test preparation, parental level of education, gender, math score, reading score and writing score. 

After formation of clusters we will implement the neural network algorithm that will be used for classification. The algorithm will predict the class on which the new student should lie.
 
                                                                  Plan of work

September	Will be completing the implementation of functions for adding and removing students using jdbc and java swing.
October	We will go for the implementation of the k-means algorithm in which we will group our data.
November	We will implement the neural network algorithm for classification.
December	Will test our system for any error and resolve the error , if any present.


                                                                  References

[1]https://www.javatpoint.com/java-swing

[2]https://www.gatevidyalay.com/tag/k-means-clustering-numerical-example-pdf/

[3]https://www.infoworld.com/article/3388036/what-is-jdbc-introduction-to-java-database-connectivity.html

[4]https://www.researchgate.net/publication/282956807_Student_performance_analysis_system_SPAS

[5]https://www.researchgate.net/publication/331161612_The_development_of_classification_system_of_student_final_assignment_using_Naive_Bayes_Classifier_case_study_State_Community_Academy_of_Bojonegoro
