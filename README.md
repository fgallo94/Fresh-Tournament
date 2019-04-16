# Fresh-Tournament

## Pre-requisites
### Database
*   If you want can use Docker to run a image with the standard ER of the exam, you must run this command

> docker run --name strategy -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d fgallo94/strategy-mysql:stable

*   Or run this script in your MySQL:
```sql
create database strategy;

use strategy;

create table ResultBattle(
    id integer not null auto_increment,
    name_of_winner varchar(100) not null,
    drink_in_body integer not null,
    PRIMARY key(id)
);
```
#### Maven

**Maven, it's an Apache software, is a build automation tool for Java projects. Maven can help you to get any libraries from web dependencies and automatically downloads on the project. Besides, Maven provides multiples-stages for building projects and plugins to get a lot of powerful tools from the community.**

**All the details of the project must be in a file called POM (Project Object Model) with ".XML" extension. This is the main resource for the creation of the project**

**In the pom.xml you can specify things like Archetypes and ArtifactId, Archetype is a Maven project templating toolkit. An archetype is defined as an original pattern or model from which all other things of the same kind are made. ArtifactId is the name of the specified jar without the version tag**

**On maven you can define different goals to result for a build, like this**

Command | Description
------- | -------------
clean 	| clean compiled class of the proyect.
package | use the compiled code and packaged it in a distribution format like jar
install | install the specified package on the local repository for using this like a dependency on others local projects.
compile | compile font code of the project.

**When you use maven you can define scopes to limit transivity of the dependencies with different scopes, like this**

Scopes 	| Description
------- | -------------
compile	| default scope, compile scoped dependencies will be in classpath.
provide	| similar to the compile, artifact should be provided by JDK / container @runtime
runtime	| not needed for the compilation but nedd @runtime.
test	| dependency oly need for test compilation and execution.
system	| same as provided, but artefact should be provided explicitly with <systemPath/>


