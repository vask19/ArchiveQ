# Instrukcja Uruchamiania Aplikacji

## Wymagania

1. **Java 17**: Upewnij się, że masz zainstalowaną wersję Java 17.
2. **Kafka Brokers**: Upewnij się, że masz uruchomiony Kafka Broker na lokalnym hoście na portach 29091, 29092, 29093.
3. **Baza danych PostgreSQL**: olx-clone korzysta z bazy danych PostgreSQL.
4. kafka topik to mailer

###run

### olx-clone
java -jar olx-clone-1.0.jar

### mailer 2
java -jar mailer-1.0.jar

# Opis Aplikacji

Aplikacja składa się z dwóch mikroserwisów: "OLX-clone" i "Mailer".

## OLX-clone (Mikroserwis 1)

- Pobiera dane z bazy danych PostgreSQL.
- Odpowiada za przetwarzanie zapytań użytkowników.
- Stanowi główną część funkcjonalności systemu, obsługując niemal wszystkie operacje.

## Mailer (Mikroserwis 2)

- Otrzymuje komunikaty od pierwszego mikroserwisu (OLX-clone).
- Wysyła użytkownikom wiadomości e-mail.

Te dwa mikroserwisy współpracują ze sobą, za posrednictwem Apache KAfka

