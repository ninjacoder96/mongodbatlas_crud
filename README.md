# MONGODB ATLAS CRUD IN ACTION

:star: If you find it educational, please consider star me on github


[MongoDB](https://www.mongodb.com/products/platform/atlas-database) Atlas is a fully-managed cloud database that handles all the complexity of deploying, managing, and healing your deployments on the cloud service provider of your choice (AWS , Azure, and GCP). MongoDB Atlas is the best way to deploy, run, and scale MongoDB in the cloud.


## Table of Contents
- [Pre-requisite](#prerequisite)
- [Installation](#installation)


## Pre-requisite 

 In order to run the spring boot application, you'll need the following installed to your computer.

- (Important) MongoDB Atlas Account
- JAVA JDK - open jdk 17 or above
- Knowledge in Object Oriented Programming
- (Optional) : [IntelliJ IDEA Conmmunity Edition](https://www.jetbrains.com/idea/)


## Installation

### Setup MongoDB Atlas Account
- Before you even started running the application, we need to setup first the MongoDB Atlas account (it's free so don't worry :smile:)
- After creating the account, click the cluster to see the connection option 
- on the ``Set up connection security `` section, You'll find connect to your application section, click the ``drivers `` and choose ``java``
- There will be a connection string generated if you have successfully created a cluster in MongoDB, it wil look something like this
  - ``mongodb+srv://joshua:<password>@cluster0.zpxjoyi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0``
- save the connection string for later.

### Run the Application through IntelliJ Idea (Recommended but Optional) <span style="color:green;" class="task-list-item-icon">✔</span>

<b>Note</b>: If you want to run the Application quickly, it is recommended that you install IntelliJ Idea which can be found in the Pre-requisite section

- Clone the project
- Open the project through IntelliJ
- right click the ``MongodbImmersionCrudApplication`` and Modify run configuration
- under build and run configurations, you'll see that you don't have jdk yet (if you don't have java jdk on the machine), click and fine the correto-17jdk 
- finally on the terminal run ``maven clean:install`` or just use the IDE to build and run the project



### Logical Data Model

This section contains sample LDM for the MongoDB App

![NoSQL-database-design-example.png](NoSQL-database-design-example.png)
