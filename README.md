Initial project to spike through considerations for ATCM.
Project is Spring Boot with Liquiase for DB schema change management.

/dev folder contains scripts for recreating database and for deploying generated .war file to a wildfly instance (if installed using brew, if other then this will need updated).

Service exposes one endpoint:

Method: POST 
Endpoint: /sjp-case
Request Headers: None
Request Body:

{
    "name" : "Bob The Criminal",
    "offences" : [
        {
            "offenceReference" : "AB12345",
            "offenceWording" : "Stole some coffee from Cafe Nero"
        }
    
    ]
}
