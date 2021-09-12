# Spring MVC Film CRUD
By: Jessica Armendariz and William Slaunwhite

### Overview
Spring MVC Film CRUD is SD30's first group assignment. The project we created is My Film Site. My Film Site is a movie database that allows you to find an existing movie or add a new release to the database. The database keeps a record of multiple aspects of each movie.

### How To Use
When a user opens My Film Site they can search for a movie by Film ID or by Keyword Search. If the movie is searched the database will display the Title, Description, Release Year, Language Id, Rental Duration, Rental Rate, Length, Replacement Cost, Rating, Special Features, Actors, and Category. The user can also add a new film, edit a film, and delete a film.

### Building Make Change
Java Technologies:
- Interfaces
- Object Encapsulation
- Return Types
- Parameters
- Method Override
- ArrayList

SQL Technologies:
- SELECT
- LIKE
- ?
- Pattern Matching

JDBC Technologies:
- Object-Relational Mapping
- PreparedStatement
- ResultSet
- Driver

Problem: Our first big hurdle was Spring Tool Suite 4 had a lot of technical issues for both us. We had issues opening the editor, linking to GitHub, and pushing and pulling from our GitHub repository without constant merge conflicts.

Solution: We asked for help from the instructors and were able to open the editor. We also sent zip files back and forth through slack to keep each other up to date with the most current code.

Problem: At one point, William's program would run and Jessica's would get error after error, even though they had identical code. 

Solution: For a short time, the team would Share Screen and work together on one computer.

Problem: Once the technical issues were out of the way, the hardest part of this project was correctly error mapping to our jsp files. My Film Site is supposed to redirect to a jsp file that explains the error you reached i.e. "Unable to Edit Film".

Solution: We were initially using primitive data types and by switching to wrapper classes we were able to correctly map the path to the jsp file and successfully explain any errors to the user.
