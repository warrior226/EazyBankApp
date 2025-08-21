# EazyBankApp
This is a simple bank application using microservices implemented in SpringBoot

Architecture Context
Controller Layer (@Controller, @RestController)
↓
Service Layer (@Service)          ← Your class is here
↓
Repository Layer (@Repository)
Relationship to Other Annotations
Annotation        Purpose              Layer 
@Service         Business logic    Service layer
@Repository      Data access      Persistence layer
@Controller      Web requests     Presentation layer
@Component    Generic component     Any layer


# What are containers & how they are different from vms

What is a container ?

A container is loosely isolated environment  that allow us to build and run software packages. These software packages include the code and all dependencies to run applications quickly and reliably on any computing environment. We call these packages as container images .

what is software containerization ?

Software containerization is an OS virtualization method that is used to deploy and run containers without using a VM . Containers can run on physical hardware, in the cloud,VMS and across multiple Oss.

what is Docker ?

Docker is an open-source platform that enables devs to automate the deployment, scaling, and managemeent of apps using containerization. Containers are lightweight, isolated environments that encapsulate an app along with its dependencies , libraries , and runtime components.

In containerization , Linux features such as namespaces and cgroups play a crucial role in providing isolation and resource management. Here’s a brief explanation of these concepts:

When you install Docker on a Linux OS,you receive the complete Docker Engine on your Linux [host.](http://host.How) However, if you opt for Docker Desktop for Mac or Windows, only the Docker client is installed on your macOs or Windows host.Behind the scenes , a lightweight vm is configured with Linux , and the Docker server component is installed within that vw .

### Architecture of Docker

Docker Client ( used to issue commands to Docker Daemon using either Docker CLI or APIs) → Docker Daemon (used to create and manage the docker images)→Docker Registry(Docker Hub or Private Registry): Docker images can be maintained and pulled from the docker hub or private container registries .

# Generate Docker images

Three different approaches are used in the industry to generate docker images for springboot web app .

**DockerFile**

We need to write a dockerFile with the list of instructions which can be passed to Docker server to generate a docker image based on the given instructions.

**Buildpacks**

It simplifies containerization since with it , we don’t need to write a low-level dockerfile.

**Google Jib**

Jib is an opeen-source Java toom maintained by Google for building Docker images of Java applications. It simplifies containerization since with it , we don’t need to write  a low-level dockerfile .

## how to package my app

first clean all the content of target directory then run the command :

```jsx
mvn clean install 
```
add this line in pom.xml file :  <packaging>jar</packaging>

then to run our microservice, type:


```jsx
mvn spring-boot:run or this commande : java -jar target/accounts-0.0.1-SNAPSHOT.jar
```