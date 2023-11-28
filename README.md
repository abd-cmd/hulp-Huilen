# Osiris microservices
In deze repo staan de microservices die samen Osiris vormen.
De applicatie is te starten door eerst `docker-compose up`  te runnen in de root van de repo.
Hierna kan elke microservice apart gestart worden op de localhost.

## Student microservice (Jan)
De student microservice is te bereiken op `localhost:8083`.
Deze service is in staat om studenten te registreren, en om deze in te schrijven voor opleidingen en vakken uit de vak microservice.
Het inschrijven voor opleidingen gebeurt nu nog met dummy data, omdat koppeling met de service van Abuzar nog niet aan bod is gekomen.

De service praat met de vak microservice via messaging, en met RPC.

### Endpoint en queues
De service heeft de volgende endpoints:
- `POST /student` om een student te registreren
- `GET /student/{id}` om een student op te halen
- `GET /student` om alle studenten op te halen
- `DELETE /student/{id}` om een student te verwijderen
- `PATCH /student/vak` om een student in te schrijven voor een vak
- `PATCH /student/opleiding` om een student in te schrijven voor een opleiding

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



