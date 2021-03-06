# Log-File-Analyzer
Note: This was my final year project during my bachelors in Information Technology. I worked on this project in 2013.

About the application:
- This is an application to parse log files to extract the most relevant information to a user and display it on a dashboard. The information displayed includes graphical representation of the data, as well as summary of the important information. Apache Lucene was used for indexing the log files. 

Purpose:
- System admins or developers who want to diagnose issues in an application deployed on the production environment can only view the log files to debug the problem
- Log files are generally very large in size, and it is cumbersome to read through the entire log file to look for important information
- A log file analyzer that parses the data in the log files to display important information in a more readable format would make debugging issues faster and more convenient
- This project aims at providing a solution to meet this need

Notable features:
  - Interface for users to add the log files
  - Indexing of log files for better search results
  - Keyword search
  - Report generation - users have the option of viewing multiple types of reports about the log files
  - PDF generation of reports
  - Graphical timeline to show when the error messages were logged
  - Recorded user search history for ease of search for commonly used search terms
  - Use of similarity index (Jaccard's coefficient) to eliminate very similar records in the log file from the summary report     (Users can still choose to view the raw log file to see all the records. But eliminating similar records from the summary      improves readability of the important data)


