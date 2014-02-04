# FISHE 
## Free Information System For Higer Education

You find here all the information you need to use and contribute to the FISHE project. If you want to know more about the domain that FISHE implements, please visit the project [wiki](https://github.com/fishe/fishe/wiki) and [website](http://www.fishe.org).

### How to Install FISHE

FISHE is an enterprise application targeting large education institutions with thousands of employees ands students. This kind of application is not easily installed because it needs a set of resources to guarantee its scalability. If you are not a technical person, you will probably have some dificulties to install FISHE dispite our effort to make this process as simple as possible. We recommend you to count on a technical friend to perform a stable and reliable FISHE installation.

#### Downloading the Source Code

For the moment, you have to start from the source code to install FISHE. We do not distribute a binary package ready to install yet. To download the source code you need to install a [Git](http://git-scm.com/) client first. Git is a distributed version control system used to manage FISHE's source code. If you use Windows or Mac, we recommend [SourceTree](http://www.sourcetreeapp.com). If you use Linux, you probably already have a command line Git client.

If you also want to contribute to FISHE, you can download the source code using your favorite IDE. We are going to explain how it is done using [Netbeans](http://www.netbeans.org) in the [contribution section below](https://github.com/fishe/fishe/edit/master/README.md#how-to-contribute-to-the-project).

#### Building an Installation Package

#### Preparing the Excution Environment

#### Deploying the Installation Package

#### Running FISHE

### How to Contribute to the Project

Fishe is built with Maven 3 or superior, making the project IDE independent, so you can chose Eclipse, Intellij, Netbeans or any other Java IDE to write your contribution. Since we work with Netbeans, we are going to explain how to contribute using it as an example. You can improve this text adding Eclipse and IntelliJ configuration if you want.

To start, perform the following steps:

1. Download Netbeans 8 or superior from https://netbeans.org/downloads/ (For the moment only Netbeans 8 Beta is available)
2. Install Netbeans in your machine and run it
3. Select `Tools / Plugins` in the menu
4. Go to the tab `Available Plugins` and search for `WildFly Application Server`
5. Select the WildFly plugin and click on `Install`
6. Restart Netbeans

Now Netbeans is ready to use. So, we are going to configure the WildFly Application Server into Netbeans to allow its management through the IDE:

1. Download WildFly from http://www.fishe.org/downloads/wildfly8-fishe-bundle-dev.zip and unzip it locally. We will refer to this location as WILDFLY_HOME from now on.
2. Select the tab `Services` in the workspace.
3. Click with the right button on `Servers` and select `Add Server...`.
4. Select the server `WildFly Application Server`, give the name `WildFly 8` and click `Next`.
5. Inform the complete path to the WildFly folder WILDFLY_HOME.
6. The server configuration will be filled automatically, but if it doesn't, then you can inform the file `WILDFLY_HOME/standalone/configuration/standalone.xml` manually. Click `Next`.
7. Make sure that the fields `Domain`, `Host` and `Port` contain the values `standalone`, `localhost` and `8080` respectively. Click `Finish`.

After these steps, `WildFly 8` is listed in the tab `Services` section `Servers`. To test if it is properly working, click on it with the right button and select `Start`. After a few seconds open a web browser and visit the address http://localhost:8080. WildFly's welcome page appears if everything is ok.
