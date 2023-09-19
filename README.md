# HULP Start Repository

Bij deze de start-repository voor de HULP opdracht.

In deze repository wordt er verteld qua programmeren hoe de Monoliet opgebouwed wordt. 
Boverdien wordt er laten zien wat voor technieken gebruikt worden en wat voor programmer taal gebruikt wordt om code te implementeren.  
Daarnaast wordt er getoond wat de use cases zijn die geïmplementeerd zijn en die behersed worden. Het Vak class is gekozen in dit branch 
van het hele domain. Er is ook gebruik gemaakt van de Opleiding class in andere branch die aangesproken moet worden met het vak class

Er is een controller package gemaakt die gebruikt wordt als een infra structure. Dat houdt in dat het nu mogelijk is om vak te beheren.
Hiermee wordt bedoeldt dat het nu mogelijk is om vak te creeren , wijzgen , updaten en halen. boviendien is er een application package die 
die de benoemde cases de mogelijkheid geeft om geactiveerd te worden dus in dit geval spreekt de controller de application package aan.
Daarnaast is er een data package die de application package aanspreekt en dit geeft toegang tot de database.

De applicatie is ook ondersteuned met unit tests. Het doel van unit-testen is om te valideren dat elke eenheid van de software werkt zoals bedoeld en aan de vereisten voldoet.

# De technieken:
* Database : h2database
* Programmeer Taal: JAVA
* Application Framework : Springboot
* Versiebeer : Github

Voor database is er gebruik gemaakt van h2database. het is een specifiek softwaretool of systeem 
waarmee u databases in uw softwaretoepassingen kunt maken, beheren en ermee kunt communiceren. 

De programmer taal java wordt gebruikt in de springboot application omdat het betrouwbaar en veelzijdig hulpmiddel is om softwareapplicaties te bouwen.

Voor framewwork is er gebruik gemaakt van Springboot. Spring Boot is een framework waarmee ontwikkelaars softwareapplicaties gemakkelijker kunnen maken en uitvoeren
Spring Boot biedt automatische configuratie voor veel algemene Spring Framework-componenten,
waardoor de hoeveelheid standaardcode die ontwikkelaars moeten schrijven wordt verminderd. 

Github is een versiebeheer waarin de springboot applicatie met de code ingestopt wordt. Bovendien toon github hoe het werk opgebouwed wordt tijdnes ontwikkling.

Er is ook een collicatie van Postman requests die demonstreert Hoe het toegevoegd , gewijzgd,verwijdeerd of gehaald wordt.
Met Postman is het mogelijk om de benoemde cases te testen.

Na opstarten kun je alvast kijken op

* http://localhost:8080/actuator voor allerhande debug info (heel soms handig)
* http://localhost:8080/h2-console voor je database.
  
  Het is niet Postgres, maar ik denk dat je de weg wel vindt. Uiteraard mag je PostGres introduceren, 
  maar zet dan ook een bijpassende Dockerfile op.

  (als het goed is kloppen de defaults, anders moet je de url/username even uit de application.properties vissen)


