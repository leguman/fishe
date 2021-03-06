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

### Getting Started as a FISHE Contributor

#### Creating the database on MariaDB

Fishe uses MariaDB for development and production. MariaDB is a fork of MySQL, so they basically function the same way, but MariaDB is evolving faster lately. We consider that you already downloaded MariaDB from https://mariadb.org and installed it on your system. We could not go into details because it depends on your environment. So, we start from the command line. Please, type the command below to start:

    #> mysql -u root -p

It will create a client authenticated session to access MySQL. "-u" means that you are passing the user of the session in the command line and "-p" means that you want to type the password right after the command has been executed. The user "root" has enough rights to create the database, but we will not use it all the time. Once authenticated, type the command below to create Fishe's database and a dedicated user for it:

    mysql> create database fishe;
    mysql> create user 'fishe_user'@'localhost' identified by 'fishe_user';
    mysql> use fishe;
    mysql> grant all privileges on fishe.* to 'fishe_user'@'localhost';
    mysql> flush privileges;

The database and a new user will be created, then we give all privileges for this user to operate the new database.

#### Installing WildFly

Now, we are going to install the WildFly Application Server. You basically need to download WildFly from http://www.fishe.org/downloads/wildfly8-fishe-bundle-dev.zip and unzip it locally. That's it! This custom bundle already comes configured for development if you carefully followed all the instructions in this file.

We will refer to the absolute path of WildFly's directory (wildfly8-fishe-bundle-dev) as WILDFLY_HOME from now on.

#### Installing and Configuring Netbeans

Fishe is built with Maven 3 or superior, making the project IDE independent, so you can chose Eclipse, Intellij, Netbeans or any other Java IDE that supports Java EE 7 to write your contribution. Since we work with Netbeans, we are going to explain how to contribute using it as an example. You can improve this text adding Eclipse and IntelliJ configuration if you want.

To start, perform the following steps:

1. Download Netbeans 8 or superior from https://netbeans.org/downloads/ (For the moment only Netbeans 8 Beta is available). Netbeans 8 is the first version of Netbeans that can be integrated with WildFly.
2. Install Netbeans in your machine and run it
3. Select `Tools / Plugins` in the menu
4. Go to the tab `Available Plugins` and search for `WildFly Application Server`
5. Select the WildFly plugin and click on `Install`
6. Restart Netbeans

To integrate with WildFly:

1. Select the tab `Services` in the workspace.
2. Click with the right button on `Servers` and select `Add Server...`.
3. Select the server `WildFly Application Server`, give the name `WildFly 8 Fishe` and click `Next`.
4. Inform the complete path to the folder WILDFLY_HOME.
5. The server configuration will be filled automatically, but if it doesn't, then you can inform the file `WILDFLY_HOME/standalone/configuration/standalone.xml` manually. Click `Next`.
6. Make sure that the fields `Domain`, `Host` and `Port` contain the values `standalone`, `localhost` and `8080` respectively. Click `Finish`.

After these steps, `WildFly 8 Fishe` is listed in the tab `Services` section `Servers`. To test if it is properly working, click on it with the right button and select `Start`. After a few seconds, open a web browser and visit the address http://localhost:8080. WildFly's welcome page appears if everything is ok.

#### Putting Your Hands on the Code

Let's download the source code from GitHub:

1. In the menu, select `Team / Git / Clone...`.
2. In the dialog, inform the repository URL `https://github.com/fishe/fishe.git`, your GitHub username and password, and the local directory where you want to clone the project. Click `Next`.
3. Select the remote branch `master` and click `Next`.
4. Make sure the field `Parent Directory` contains the path you have chosen to clone the project, `Clone Name` contains `fishe`, `Checkout Branch` is `master` and `Remote Name` is `origin`.
5. Then click `Finish`.
6. Netbeans will suggest to open the project you just cloned. Click on `Open Projects...`.
7. Select all projects in the list and click `Open` to finish.

Now you are ready to contribute to Fishe!

When you finish your contribution, it's time to share it with the rest of the community. There are two ways of doing that. If you are already a committer then you already have permission to commit directly, if not then you have to do a pull request.

if you are a committer you have to perform the following steps to send your contribution to the main repository:

1. commit your changes locally.
2. update your local copy with the updates available on the server.
3. in case of conflicts, solve all of them and commit the changes.
4. push all local commits to the server.

To commit your changes locally:

1. Select the project `fishe` and go to the menu `Team / Commit`
2. In the new dialog, write a commit message containing at least the number of the issue you are working on (i.e.: Issue #5: implementation finished, but tests are still incomplete).
3. In the same dialog, select the files you want to include in the commit. Make sure to not include IDE specific files such as `nb-configuration.xml`.
4. Click on `Commit` when you're done.

When using Git, your commits are not imediatly sent to the server. They stay locally until you push them to the server. Meanwhile other people are already pushing their changes to the server, so before pushing your changes you have to make sure that there is no conflicts between your local changes and the server ones. To check this, you have to update your local copy as follows:

1. Select the project `fishe` and go to the menu `Team / Remote / Pull...`.
2. In the dialog, leave the option `Select Configured Git Repository Location` selected and click `Next`.
3. Select the remote branch `master -> origin/master` and click `Finish`.

At this point you will know whether there are or not conflicts to solve. If there are conflits, try to solve them or contact the project leader to know how to proceed. After solving the conflicts, a new commit is needed to include the manual merge. For that, you may repeat the commit instructions above.

Finally, it's your turn to push your changes to the server. Proceed as follows:

1. Select the project `fishe` and go to the menu `Team / Remote / Push`.
2. In the dialog, leave the option `Select Configured Git Repository Location` selected and click `Next`.
3. Select the local branch `master -> master` and click `Finish`.

Your code is finally sent to the server and it is now available for other developers.
