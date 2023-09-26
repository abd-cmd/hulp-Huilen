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
Bovendien is de applicatie ondersteund met integratie tests om te checken of use cases werkend zijn.

# De technieken:
* Database : Postgressql
* DBMS : Pgadmin
* Programmeer Taal: JAVA
* Application Framework : Springboot
* Versiebeer : Github
* Docker: Docker compose file voor de database 

Voor database is er gebruik gemaakt van Postgressql. het is een specifiek softwaretool of systeem 
waarmee u databases in uw softwaretoepassingen kunt maken, beheren en ermee kunt communiceren. 

De programmer taal java wordt gebruikt in de springboot application omdat het betrouwbaar en veelzijdig hulpmiddel is om softwareapplicaties te bouwen.

Voor framewwork is er gebruik gemaakt van Springboot. Spring Boot is een framework waarmee ontwikkelaars softwareapplicaties gemakkelijker kunnen maken en uitvoeren
Spring Boot biedt automatische configuratie voor veel algemene Spring Framework-componenten,
waardoor de hoeveelheid standaardcode die ontwikkelaars moeten schrijven wordt verminderd. 

Github is een versiebeheer waarin de springboot applicatie met de code ingestopt wordt. Bovendien toon github hoe het werk opgebouwed wordt tijdnes ontwikkling.

Er is ook een collicetie van Postman requests die demonstreert Hoe het toegevoegd , gewijzgd,verwijdeerd of gehaald wordt.
Met Postman is het mogelijk om de benoemde cases te testen.

Na opstarten kun je alvast kijken op


* http://localhost:5050 voor de DBMS, login is admin@admin.com en wachtwoord is admin.
* login voor postgress is is username postgres en wachtwoord postgres
* [Azure deploy](https://huilen.huilen.p.azurewebsites.net)
---
# Splitsing monoliet (Osiris)
Wij hebben er voor gekozen om de splitsing aan te houden die ook als suggestie op canvas staat

> * Studenten in/uitschrijven (met allerhande regeltjes). 
Denk hierbij aan vooropleiding, BSAs, herkomst. Bij uitschrijving kan er misschieen een deelgraad (propedeuse, bachelor, minor, etc.) 
behaald worden. Een decaan kan voor sommige vereisten juist weer vrijstellingen verlenen.

>* Vakken beheren, en hoe de cijfers opgebouwd zijn (toetsen, herkansingen, vervangende opdrachten etc.)
  Per jaar kunnen er uiteraard andere regels gelden, maar standaard is het ‘hetzelfde als vorig jaar’

>* Opleidingen beheren, en welke vakken er nodig zijn om het te halen (vervangingen, bezemvakken, vrijstellingen etc.).

### Jan
Ik heb de splitsing over de studenten op me genomen, en heb geprobeerd om me hier aan de DDD principes te houden,
dit is vooral in de persoonsgegevens terug te vinden. 

## Abuzar
Ik heb het domein opleiding gemaakt. Binnen dit domein kan een opleiding bestaan uit meerdere vakken.

### Het gebruik van collega module
Ik maak gebruik van het domein "vak" dit is ontwikkeld door Abdul, binnen een opleiding kunnen verschillende vakken vallen. Daarom heb ik een lijst met vakken voor de opleiding opgesteld. In deze lijst zijn twee methodes geïmplementeerd: één om een vak toe te voegen ('add') en een andere om een vak te verwijderen ('remove').

### Besteede aandacht
Ik heb mij voornamelijk gericht op de implementatie van het domein en de overwegingen bij het opzetten van het Docker Compose-bestand en het creëren van een eventuele service voor de monoliet. Helaas heb ik niet voldoende aandacht kunnen besteden aan de unit tests
