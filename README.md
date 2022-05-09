# Hotel-Management
Take Home assessment 

## Question:
Create a data model to support a hotel reservation system (class diagram with relationships) - the diagram can be submitted as PDF or JPG/PNG image.
Implement this model using Java. In addition to the data model, implement a program (simple class with main method) that can take in user input to answer the following questions:
	Is a given room type available on a given date?
	Change the price of a range of rooms (by room number, e.g. rooms 10-15) or apply a special offer price to a range of rooms.
Once complete, send us your assignment. It can be a zip file or a github project as well. If you email it and it gets blocked by our security policy, you may need to rename the .java files as .txt.
Your code should be at a production-ready standard of quality.


## Assumptions:
	- Booking is allowed from either today or later dates.
	- Booking is allowed for any single day and for any number of days.
	- 4 types of Rooms are available
	- Single hotel doesn't have more than 100 rooms per floor and doesn't have more than 10 floors.
	- Total number of rooms are around 10000 for single hotel.
	- When changing the price for range of rooms, ignore the room numbers which are not in the hotel.

## Limitations:
	- Booking is allowed for current year only
	- Booking is based on date irrespective of the time. 

## Future Scope (To make system production ready):
	- System can be made by integrating bussiness logic in Spring REST backend API use of RDBMS databse so that jar could deployed to server.
	- System can be enhaced to allow booking for later years.
	- Allow time based booking.
	- Customer based booking and acknowledgement receipt generation.
	- Authentication & Authorization can be integrated using 3rd party API(Google, FB, Github) or can be our own (oauth2).
	- Loggers can be added to log useful information.
	- Use of user defined exception to throw certain exception during validations.
	- Dynamic pricing can be added for rooms, e.g. Room rates would change based on season without explicitly changing them.
	
