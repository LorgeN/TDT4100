# Interface - Named-oppgave

Denne oppgaven handler om et grensnitt (interface) for person-navn og hvordan slike implementeres og sorteres med grensesnittet `Comparator`.

I denne oppgaven tar vi utgangspunkt i at en person har et navn (`String`) bestående av fornavn ("given name") og etternavn ("family name") som sammen gir personens fulle navn ("full name").

## Del 1

Definer et grensesnitt `Named` med følgende metoder:

- `setGivenName(String)` og `String getGivenName()` for å sette og hente fornavn
- `setFamilyName(String)` og `String getFamilyName()` for å sette og hente etternavn
- `setFullName(String)` og `String getFullName()` for å sette og hente personens hele navn. Argumentet til set-metoden skal være fornavn og etternavn skilt med mellomrom. Tilsvarende skal get-metoden returnere fornavn og etternavn skilt med mellomrom.

## Del 2

Lag klassene `Person1` og `Person2` som begge implementerer grensesnittet `Named`. `Person1`-klassen skal ha felter for for- og etternavn (altså `givenName` og `familyName`) og en konstruktør som tar inn to tilsvarende argumenter. `Person2` skal ha ett felt for fullt navn (`fullName`) og en konstruktør som tar inn det fulle navnet. Begge skal imidlertid implementere samme logikk, dvs. ha get- og set-metoder for fornavn, etternavn og fullt navn. Man kan anta at brukeren oppretter `Person1` og `Person2`-objekter med gyldige navn, altså trenger man ikke å implementere valideringsmetoder.

## Del 3

For å kunne sammenligne `Named`-objekter, f. eks. for å sortere en kontaktliste, kan du lage en klasse kalt `NamedComparator`, som implementerer grensesnittet [Comparator](https://www.ntnu.no/wiki/display/tdt4100/Sortering+med+Comparable+og+Comparator). `NamedComparator`-objektet skal brukes for å sammenligne navn parvis: Først på etternavn og deretter på fornavn om etternavnene er like. Dette kan gjøres ved å la `NamedComparator`-klassen implementere metoden `int compare(Named named1, Named named2)` med følgende logikk:

- Dersom etternavnene er ulike skal metoden
    - returnere et negativt heltall om det første etternavnet er alfabetisk ordnet før det andre,
    - eller et positivt heltall i motsatt tilfelle.
- Dersom etternavnene er like skal metoden gjøre det samme på fornavnene. Dersom også fornavnene er like skal metoden returnere 0.

Skriv testkode som bruker `Collections.sort`-metoden på en `ArrayList<Named>`, for å teste om `NamedComparator`-klassen har implementert [Comparator](https://www.ntnu.no/wiki/display/tdt4100/Sortering+med+Comparable+og+Comparator) riktig.

Hint: For å sammenlikne to `String`-objekter kan man bruke `String`-klassens innebygde `Comparable`-metode `int compareTo(String streng2)`. Denne metoden sammenlikner en `String` med en annen alfabetisk.

## Exercise-panelet

Bruk av Exercise-panelet er obligatorisk for denne øvingen. Du må ha panelet åpent med Named.ex-filen (tests > interfaces > Named.ex) i før du begynner med oppgaven. For mer informasjon/hjelp, se nederst på forrige side, altså hovedsiden for [Øving 6](./README.md).
