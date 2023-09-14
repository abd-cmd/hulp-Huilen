# HULP Start Repository

Bij deze de start-repository voor de HULP opdracht.

In deze repository wordt er verteld qua programmeren hoe de Monoliet opgebouwed wordt. 
Boverdien wordt er laten zien wat voor technieken gebruikt worden en wat voor programmer taal gebruikt wordt om code te implementeren.  
Daarnaast wordt er getoond wat de use cases zijn die geïmplementeerd zijn en die behersed worden.

# De technieken:
* Database : h2database
* Programmeer Taal: JAVA
* Application Framework : Springboot
* Versiebeer : Github

Voor database is er gebruik gemaakt van h2database. Het slaat gegevens op in het geheugen en bewaart de gegevens niet op schijf. 
De programmer taal java wordt gebruikt in de springboot application omdat Het biedt beheert REST-eindpunten. 
In Spring Boot wordt alles automatisch geconfigureerd; er zijn geen handmatige configuraties nodig. 
Voor framewwork is er gebruik gemaakt van Springboot. Met Spring Boot kunt u eenvoudig stand-alone, op Spring gebaseerde
applicaties van productiekwaliteit maken die u "gewoon kunt uitvoeren". Spring Boot biedt automatische configuratie voor veel algemene Spring Framework-componenten,
waardoor de hoeveelheid standaardcode die ontwikkelaars moeten schrijven wordt verminderd.




Na opstarten kun je alvast kijken op

* http://localhost:8080/actuator voor allerhande debug info (heel soms handig)
* http://localhost:8080/h2-console voor je database.
  
  Het is niet Postgres, maar ik denk dat je de weg wel vindt. Uiteraard mag je PostGres introduceren, 
  maar zet dan ook een bijpassende Dockerfile op.

  (als het goed is kloppen de defaults, anders moet je de url/username even uit de application.properties vissen)


