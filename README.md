# Project Exceptional Zoos

A student that completes this project shows that they can:

* implement industry standard exception handling including user friendly exception messages
* troubleshoot running services using both system and programmatically generated logs

## Introduction

## Instructions

Starting with your java-zoo application (instructions for that application can be found at https://github.com/BloomInstituteOfTechnology/java-zoos.git)

Add appropriate exception handling routines. Required exceptions to handle are when
  * a resource is not found
  * the wrong data type is used for a path variable
  * a non-handled endpoint is accessed (a URL not found exception)
  * (other standard exceptions can also be handled)
  * include a generic exception handler to trap all exceptions not previously handled

Add appropriate logging routines. Required logging include
  * Activating actuator endpoints
  * Tomcat logging routed to a separate log file
  * Custom logging under each Get endpoint saying the endpoint has been accessed
    * should only go to console
    * for example when a client calls PUT /students/Student log should say "PUT /students/Student accessed"
    * include in log any appropriate parameters sent to the end point
  * Note: put the log files under the directory /tmp/var/logs/lambdajx You may have to create some directories for this to work.
  * Log when each class and method is accessed in the zoo application.

## Stretch Goals
  * for each log, add a date and time stamp.
  * Make the endpoint /zoos/zoos pageable and sortable
