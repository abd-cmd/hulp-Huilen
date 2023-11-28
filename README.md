#Abdel
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

