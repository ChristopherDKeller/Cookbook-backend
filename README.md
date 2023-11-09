# Cookbook-backend

1. N:M-Beziehung:
    - N:M-Beziehung zwischen Rezepten und Zutaten. Verbindungsentitätenmodells durch `Recipe_Ingredient`-Klasse

2. Einheit für Zutaten:
    - Einheit für Zutaten. verschiedene Rezepte unterschiedliche Einheiten für dieselbe Zutat verwenden können (z. B. Gramm oder Tassen).

3. Anzahl Attribut:
    - Attributs zur Speicherung der Menge (z. B. `BigDecimal quantity`), um die Menge der Zutaten in einem Rezept zu speichern.

4. Validierung und Datenüberprüfung:
    - Validierungen und Datenüberprüfungen in Backend implementieren, um sicherzustellen, dass Daten konsistent und fehlerfrei gespeichert werden.

5. Nutzerfreundlichkeit:
    - Frontend benutzerfreundlich gestalten, z. B. durch eine einfache Möglichkeit, Zutaten hinzuzufügen und Rezepte zu erstellen.

6. Suchfunktion:
    - Eine Suchleiste und eine Zutatenliste. Benutzer sollten einfach nach Zutaten suchen/filtern können, um Rezepte zu finden.

7. Portionen:
    - Hinzufügen von Portionen zu Rezepten, damit Benutzer die Menge der Zutaten automatisch anpassen können, wenn sie die Portionen ändern.

8. Erweiterte Funktionen:
    - Erweiterte Funktionen wie Bilder für Rezepte


____________________________________________________________________________________________________________________________
Notizen:

Frontend:
- Auswahl Zutaten über suchleiste/ Liste etc.
- Kann Zutaten zu DB hinzufügen
- Am Ende wird fertiges Rezept angezeigt mit Liste an Zutaten mit Einheit und multipliziert mit Anzahl Attribut.

Backend:
- Name ist Primärschlüssel für Zutaten
- Zutaten haben Name, Einheit
- Rezept hat Zeit, Titel, Beschreibung, Portionen

DB:
- Zutaten werden abgespeichert
- Rezepte werden abgespeichert
- N:M verbunden mit Anzahl Attribut (BigDecimal)