# OOP-Project-2017

JCF Ticket Management Application

The Jamaica Constabulary Force (JCF) Traffic Division has a great challenge in fulfilling its mandate of monitoring the islands motorists. The division is tasked with tending to the roadways to ensure adherence to the road code by motorists and their vehicles. One major challenge the force faces is the inability to easily access pertinent information about offenders. For instance, when warrants are issued for motorists with overdue tickets, there is no quick or convenient way officers may check when patrolling the streets or when an offender has been stopped.

The Government of Jamaica (GOJ) has recently secured a grant to develop an application to aid the division and their 
officers in capturing the offence details from the issued tickets as well as a means to check for outstanding tickets and 
warrants by the offender. They hope to deploy the developed application on handheld devices issued to officer’s however the GOJ has asked your team to provide proof-of-concept by simulating how the application would work by implementing it using the concepts covered in this module.

When an offense is committed by a commuter the officer issues a ticket. When a commuter is given a ticket, they should make full payments within twenty-one (21) days of the issue date. If the offender wishes to challenge the issued ticket they may attend court on the court date specified on the ticket. The court date is usually set at three (3) months after the issue date. If the commuter fails to pay for the ticket by the payment due date, they should no longer be able to pay for the ticket using the application and must attend court to resolve the matter on the court date specified on the issued ticket. If the commuter fails to show for court on the court date, the court shall issue a warrant for the offender’s arrest.

The system should have three (3) types of users – Administrators, Officersand Commuters. Administrators manage the users of the system and are able to flag commuters who have warrants out. Officers are able to add new tickets for commuters and check for warrants. Commuters are able to check and pay for outstanding tickets. The traffic officer collects the following information for the ticket:
- Ticket Number (Must be unique)
- Offenders Name (First and Last)
- Offenders Date of Birth
- Offenders Driver’s License Number (TRN)
- Offenders Vehicle Plate#
- Date of Offence (Issue Date)
- Payment Due Date
- Traffic Court Date
- Address/Location of Offence
- Offence Description (Speeding, Operating Vehicle with Suspended Registration, Careless driving, etc.)
- Total Due
- Officers Name
- Officers Badge
- Officers Precinct

The basic functional expectations of the ticket management application are:

1. All relevant information should be stored in suitable files. When the program is run, it should maintain data by reading and writing files. When the user decides to exit the program any changes should have been saved to the respective files.

2. A file storing all the system user credentials should exist. The file should store the users: Username, Password, Type -Officer/Commuter/Administrator.

3. Administrator:
  - Shall have the username “admin” and the password “@dm1n”
  - Shall have a menu which allows them to CRUD (Create, Retrieve, Update and Delete) Officers and Commuters
  - Shall be able to add or remove warrants for Commuters

4. Officers should be provided with features that allows them to:
  - Create a new ticket for a Commuter
  - View all tickets outstanding for a commuter using TRN
  - Check if a warrant is out for the commuter

5. Commuters should be provided with features that allows them to:
  - View all of his/her outstanding tickets
  - Pay for tickets (only full payments are accepted)
