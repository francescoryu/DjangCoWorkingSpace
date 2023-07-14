# M223 Projekt Djan-Co Working Space

Djan-Co Working Space ist ein Projekt, wo man sich Räume für das autonome Arbeiten mieten kann.

## Erste Schritte für Postman

1. Bei Postman gehen Sie oben links auf "import".
2. Dann ziehen Sie das File in die "Drag and Drop" Zone.
3. Dann gehen sie auf die drei Punkte neben der Collection und drücken Sie Run Collection.



## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Quelle
ChatGPT