# HikingTrail Web Application

## Intro
People fail to understand the importance of exercising and how not doing so impacts their life. For one exercise does not just help you lose weight but also reduces the risk of heart disease, improves mental health, along with minimizing other health risks. Many people have tried the common forms of exercise such as running, lifting weights, or playing sports, and has proven to not be their preferred form of exercise. HikingTrails is being developed to provide an easy-to-use website for new users looking to start hiking and who do not know where to go. HikingTrails will allow users to search and view trails, add a trail to their favorites, and add an event that shows the user has completed the trail along with a description left by them. HikingTrails is great for those people who want to get outside, explore, and try something new when exercising.

## Function Requirements
The following is a list of high-level functional requirements:
* Login and Registering a User
* Viewing and Updating User Profile information 
* Viewing all Trails on the Explore Page
* Searching for specified Trails on the Explore Page
* Creating a bookmark of a Trail 
* Removing a bookmark from the user profile
* Creating an Event of a trail and inputting information related to their experience. 
* Removing an Event from user profile 
* Admin capabilities such as:
* Viewing a table of all users registered to the website.
* Suspending a user’s account
* Removing a user’s account 
* Change a user’s role within the website. 
## Non-functional Requirements 
* Page Security is implemented for each Page on the web application.
* Logging method entries and exits using SLF4J
* Global Exception handling 

## Technologies
* Spring Boot v2.3.4
* React v16.14.0 
* MongoDB v4.4.1 
* Postman v7.9.0
* Heroku v20

The HikingTrails Application uses Spring Boot for the back-end development and the React Framework implemented by JavaScript for the front-end development. When developing a project in Spring Boot it offers numerous starter dependencies for simply building and application configuration. React is popular JavaScript library within the industry for developing complex user interfaces. Postman was also an important factor during development to test the API calls along with generated the API documentation.
### Cloud Service:
The application is deployed to Heroku using a pipeline that auto deploys both applications to their cloud server when a new commit is pushed to the main branch on GitHub. Since Heroku provides a console for the host to view SL4J logger was implemented along with global exception handling to handle errors in API calls. 

## What New Technologies to Myself Were Implemented?
Spring Boot, React, MongoDB, and Heroku were all-new technologies that were chosen to be implemented into the application. These technologies were chosen because I wanted to challenge myself by having to learn them on my own and develop a project myself with what I have taught myself. React was specifically chosen for the fact that is a popular technology used by many companies in today’s industry. Having prior experience in Spring made Spring Boot easier and faster to learn and develop the back-end along with implementing MongoDB as the chosen database. Deploying an application for the first time to Heroku was such a great experience seeing as there were no issues encountered when deploying both applications and creating their pipelines. 

## Daigrams
![5 ExplorePage](https://user-images.githubusercontent.com/37810476/113539959-d61eb580-9593-11eb-8e20-742e12da6a32.PNG)
![4 ProfileEvents](https://user-images.githubusercontent.com/37810476/113539971-e171e100-9593-11eb-9de4-f1161fc6c105.PNG)
### The wireframes displayed above are an example of how the design of the application came to be.

![logicalDiagram - Copy](https://user-images.githubusercontent.com/37810476/113539926-c010f500-9593-11eb-882c-a672e587f66b.png)
### The logical diagram above provides a visual representation of the flow of the application itself and the different technologies implemented.

![physical diagram - Copy](https://user-images.githubusercontent.com/37810476/113539930-c1dab880-9593-11eb-9f78-085174d3584a.png)
### The physical diagram above demonstrates how the Client Tier, Web Application Tier, and External Resources connect with one another to better understand how the application will communicate.

## Challenges
* A big challenge I came across during the development of the application included React, seeing that I am new to react and still have a lot to learn with this framework. 
* Another challenge was initially deploying the application to AWS and running into build issues but to meet the deadline the application was deployed to Heroku using a pipeline with success.
* Some of the popular resources used during development included stack overflow, YouTube, and mainly articles found on google along with documentation that was provided by the technologies.

## Current Issues within the application:
* The application was initially supposed to be deployed to AWS.
* CSS design issues for certain pages such as responsive pages
* I planned on implementing a feature for editing an event but failed to get it working before the deadline.
* Components on the React application could have been better created for reusability
