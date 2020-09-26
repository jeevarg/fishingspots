# Application Flow

### Continue as Guest / click on Spots menu

- User can select continue as a guest, which takes him to the Spots page. 
- User can then enter the search criteria to view the spots on the map. 
is signed in already).
- Rest of the steps are the same as carried out to View Spots.

### User Sign up

- User chooses sign up on the menu (available on all pages, unless the user 
is signed in already).
- User fills out the sign up form and submits.
- Request goes to sign up servlet.
- Servlet creates a user object and then creates user in the database.
- Response to user confirming addition (show a message on the jsp)

### User Sign In

- User chooses sign in on the menu (available on all pages, unless the user 
is signed in already).
- User enters username and password on form and submits. 
- If user is authenticated, the server will handle allowing access to edit 
pages. 
- If authentication fails, show error message/page.


### View Spots

- Page sends a request to view spots servlet along with criteria 
(city, state, miles OR zipcode, miles).
- Servlet uses the spots dao to select spots according to criteria
- Dao performs select and creates spot objects from results.
- Dao returns list of spots matching criteria to servlet.
- Servlet sends list back to spots  jsp.
- Spots jsp displays the spots.


### Add Spot

- Option only available to logged in users.
- User enters spot  details
- Details are sent to Add Spot  servlet
- Servlet creates spot  object
- Servlet sends object to dao
- Dao adds spot to the database
- Servlet sends confirmation to SpotAdd page that spot has been added.

### Edit Spot 

- Option only available to logged in users.
- User selects a spot on the map and clicks on edit button in the pop-up window. 
- Details are sent to Edit Spot  servlet
- Servlet creates spot  object with the updated information.
- Servlet sends object to dao
- Dao edits the spot in the database
- Servlet sends confirmation to Spots page that spot has been edited.


### Delete Spot 

- Option only available to logged in users.
- User can only delete his/her spot(s). User selects their spot and click on delete button. 
- Details are sent to Delete Spot  servlet
- Servlet creates spot  object with the delete information.
- Servlet sends object to dao
- Dao deletes the spot in the database
- Servlet sends confirmation to Spots page that spot has been deleted.

### About

- Static page - html only? 
- Consider making contact info configurable.
