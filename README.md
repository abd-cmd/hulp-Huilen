# Abdel
In Vak module wordt een vak object gemaakt door de volgende gegevens te geven:

1 vak naam
2 vak periode
3 vak bescikbaarpleken
4 vak herkansinggegevens
5 vak ingangeisen
6 vak looptijd
7 vak toetsgegevens

vak herkansinggegevens bevat herkansingsperiode ,herkansingDatum en herkansingPunten;
vak toetsgegevens bevat vorm ,toetsDatum en toetsPunten;
vak ingangeisen bevat EC ,vrijstelling;
vak looptijd bevat beginDatum ,eindDatum ;

Bovendien bevat de Vak module twee object Student en Opleiding.
die zijn duplicatie classes die info bevatten van de benodigde gegevens voor de vak module.

Student bevat id en naam
Opleiding bevat opleidingId , naam en begindatum

In dit module zijn er twee soorten koppelingen RPC en Messaging.

De messaging wordt gebruikt om student object te krijgen van Student module en toe te voegen aan de list van students van het vak voor het geval de student een id opleiding heeft.
Voor het geval dat student zijn gegevens wijzgt , wordt een message gekrijgen in het vak om zijn gegevens te wijzgen in database van het vak.
Voor het geval dat student verwijdeerd wordt , wordt een message gekrijgen in het vak om student weg te halen in database van het vak.
Bovendien wordt messaging gebruikt om de updatedGegevens van vak te sturen naar Studnet module en ook voor het geval het wordt verwijdeerd wordt een message gestuurd naar de student module dat het vak verwijdeerd is
Daarnasst stuurt het vak module EC punten naar student module voor het geval dat de student toets haalt.

De RPC wordt gebruikt met de opleiding module om eerst te zien wat voor opleidingen zijn en wat de id is van elke opleiding.
Daarnaast wordt de RPC gebruikt om het vak te sturen naar Opleidng module zodat het vak ingeschrijven wordt bij de opleiding.
Bovendien wordt via RPC de id gestuurd voor het geval dat het vak verwijdeerd wordt.


# Osiris microservices
In deze repo staan de microservices die samen Osiris vormen.
De applicatie is te starten door eerst `docker-compose up`  te runnen in de root van de repo.
Hierna kan elke microservice apart gestart worden op de localhost.

## Student microservice (Jan)
De student microservice is te bereiken op `localhost:8083`.
Deze service is in staat om studenten te registreren, en om deze in te schrijven voor opleidingen en vakken uit de vak microservice.
Het inschrijven voor opleidingen gebeurt nu nog met dummy data, omdat koppeling met de service van Abuzar nog niet aan bod is gekomen.

De service praat met de vak microservice via messaging, en met RPC.
Ook praat de service met de Student microservice van de Canvas Applicatie van het andere team.

### Endpoint en queues
De service heeft de volgende endpoints:
- `POST /student` om een student te registreren
- `GET /student/{id}` om een student op te halen
- `GET /student` om alle studenten op te halen
- `DELETE /student/{id}` om een student te verwijderen
- `PATCH /student/vak` om een student in te schrijven voor een vak
- `PATCH /student/opleiding` om een student in te schrijven voor een opleiding
- `PATCH /student/klas` om een student in te schrijven voor een klas

De service produceert berichten op de volgende queues:
- `new-student-queue` Hier komen berichten op als er een nieuwe student is geregistreerd
- `updated-student-queue` Hier komen berichten op als er een student is geupdate
- `deleted-student-queue` Hier komen berichten op als er een student is verwijderd
- `opleiding-inschrijving-queue` Hier komen berichten op als er een student is ingeschreven voor een opleiding
- `vak-inschrijving-queue` Hier komen berichten op als er een student is ingeschreven voor een vak

De service consumeert berichten van de volgende queues:
- `new-opleding-queue` Hier komen berichten op als er een nieuwe opleiding is aangemaakt vanuit de opleiding microservice
- `Add-Vak` Hier komen berichten op als er een vak is aangemaakt vanuit de vak microservice
- `Update-Vak` Hier komen berichten op als er een vak is geupdate vanuit de vak microservice
- `Delete-Vak` Hier komen berichten op als er een vak is verwijderd vanuit de vak microservice
- `SendPuntenVak` Hier komen berichten op als een student een vak behaald heeft

### Verbeteringen sinds vorige versie
- Studenten kunnen nu ook ingeschreven worden voor klassen via de Student microservice van Jan (Het andere team)
- Messaging weggehaald uit de presentation layer
- RestTemplate weggehaald uit de presentation layer
- Gebruik van interfaces ipv harde dependencies in de service klasses
- 



