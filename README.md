# lnd-eventsource-readmodels

L&amp;D (Learning and Development) exercise to build a read-model from an event store

>Given a pre-populated Event Store, create a process that can answer queries about the event data.

## Outline

Given a PostgreSQL database Event Store, create a new read-model that can answer questions about the event data.
The automated test scripts are provided as [PostMan scripts](https://www.getpostman.com/) and can be run from the command line with [newman](https://www.npmjs.com/package/newman).

## Details

The data in question is a set of Game events.
These events reflect what can happen over the lifetime of a Game.

Game Events:

* Game Created - `GAME_CREATED`
* Player Registered - `PLAYER_REGISTERED`
* Player Deregistered - `PLAYER_DEREGISTERED`
* Game Started - `GAME_STARTED`
* Player left - `PLAYER_LEFT`
* Game completed - `GAME_COMPLETED`

Players can register when a game is created or started, but not completed.
Before the game starts a player may `unregister` to create a `Player Deregistered` event.
Once the game has started a player may `leave` to create a `Player Left` event.
A completed game will also contain the resulting leaderboard for the game.

Game events may be interlaced within the data set.
For example several Games may be created before any player registered for one of them.
Registrations may then happen for various games.
As this data set represents an event store, the event sequence is deterministic and always returned in that same order.

## Task

Given the set of Game events served via the HTTP API, build up a read-model in memory that can answer the following queries:

* List the highest point scorers
* List pairs of players who play together most frequently
* List the most delayed game starts
* Get the Mean average time for a Game to start

## Expectations

You should *fork this repository* and produce your implementation there.
Present your final implementation to your mentor.

Your implementation should :

* satisfy the postman scripts
* build and run in docker so your reviewer is not required to have the same dependencies installed

You are not required to update the read model after the initial load.
An initial load is satisfactory for this exercise.

## Prerequisites

If you are going to run and build the distribution within IntelliJ then setup local ENVIRONMENT variables of:
* QUERY_PORT=8080
* EVENTSOURCE_DB_URL=jdbc:postgresql://lnd-eventstore-db:5432/postgres?user=postgres&password=password

Note that this eventsource is postgres but you can set this to some other instance if needed.

## Salesforce & Java

If you are using a Salesforce macOS laptop, you will need to set your java up.  Follow these steps:

1. Install Homebrew if you haven't already.  Open a terminal and paste in this command:
`/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
2. Tap the available cask versions available:
`brew tap homebrew/cask-versions
3. Install JDK17 (not the latest = 22... compatability issues!) using:
`brew install --cask homebrew/cask-versions/zulu17`
   
### Docker

The eventstore is a PostgreSQL instance running in a docker container.
You will be expected to use `docker-compose` to run your query-API in a container that connects to the PostgreSQL instance.

You will expose your web server container on port 8080.

You can connect to the PostgreSQL database from your container with the following credentials:

 * hostname and port : `lnd-eventstore-db:5432`
 * user : `postgres`
 * password : `mysecretpassword`

Use the PostgreSQL library and driver of your choice for the language you are implementing the queryAPI in.

You will use a command like `docker-compose up --build` to build and run your containers.
The existing _docker-compose.yml_ file is expecting you to update the _docker/game-readmodel-queryapi/game-readmodel-queryapi.dockerfile_ with the necessary scripts to build and run your container.

### Postman

You can install the Postman GUI from here - https://www.getpostman.com/.
If you want to run from the command line, then _newman_ can be installed via NPM

```bash
npm install -g newman
```

The scripts can be executed with newman as such:

```bash
newman run ./postman/LnD-Readmodels.postman_collection.json
```

With the expected output of

```bash
LnD Readmodels

→ Highest Point Scorers
  GET http://localhost:8080/game/leaderboards/points [200 OK, 347B, 72ms]
  ✓  Status code is 200-Ok
  ✓  Payload as expected

→ Most Common Opponents
  GET http://localhost:8080/game/leaderboards/opponents [200 OK, 500B, 15ms]
  ✓  Status code is 200-Ok
  ✓  Payload as expected

→ Game start delays
  GET http://localhost:8080/game/startDelays [200 OK, 340B, 7ms]
  ✓  Status code is 200-Ok
  ✓  Payload as expected

→ Game start mean average
  GET http://localhost:8080/game/startDelayMean [200 OK, 174B, 5ms]
  ✓  Status code is 200-Ok
  ✓  Payload as expected

┌─────────────────────────┬──────────┬──────────┐
│                         │ executed │   failed │
├─────────────────────────┼──────────┼──────────┤
│              iterations │        1 │        0 │
├─────────────────────────┼──────────┼──────────┤
│                requests │        4 │        0 │
├─────────────────────────┼──────────┼──────────┤
│            test-scripts │        4 │        0 │
├─────────────────────────┼──────────┼──────────┤
│      prerequest-scripts │        0 │        0 │
├─────────────────────────┼──────────┼──────────┤
│              assertions │        8 │        0 │
├─────────────────────────┴──────────┴──────────┤
│ total run duration: 247ms                     │
├───────────────────────────────────────────────┤
│ total data received: 802B (approx)            │
├───────────────────────────────────────────────┤
│ average response time: 24ms                   │
└───────────────────────────────────────────────┘
```

### Example of data

| position   | stream_type  | stream_id  | version  | event_type      | payload |
|------------|--------------|------------|----------|-----------------|---------|
| 1          | 'Game'       | 'Game1'    | 1        | 'GAME_CREATED'  | `'{"name": "Game1", "createdAt": "2000-01-01T12:00:00Z", "minPlayers": 2, "maxPlayers": 5}'`|
| 2          | 'Game'       | 'Game2'    | 1        | 'GAME_CREATED'  | `'{"name": "Game2", "createdAt": "2000-01-01T13:00:00Z", "minPlayers": 3, "maxPlayers": 5}'`|
| 3          | 'Game'       | 'Game1'    | 2        | 'PLAYER_REGISTERED'  | `'{"playerHandle": "Adam"}'`|
| 4          | 'Game'       | 'Game1'    | 3        | 'PLAYER_REGISTERED'  | `'{"playerHandle": "Bob"}'`|
| 5          | 'Game'       | 'Game1'    | 4        | 'GAME_STARTED'  | `'{"startedAt": "2000-01-01T15:00:00Z"}'`|
| 6          | 'Game'       | 'Game1'    | 5        | 'GAME_COMPLETED'  | `'{"completedAt": "2000-01-01T15:10:00Z", "results": [{"playerHandle": "Bob", "points": 10},{"playerHandle": "Adam", "points": 5}] }'`|

With this example data we can see that:

 * 2 games have been created
 * 1 of the games (_Game1_) has 2 players (_Adam_ and _Bob_) registered to it.
 * 1 of the games (_Game1_) has started 3 hours after being created.
 * 1 of the games (_Game1_) has completed 15minutes after starting with _Bob_ getting 10 points and _Adam_ getting 5 points.

### Implementation notes

Your results should be deterministic.
This means if there is a dead-heat on a leaderboard, the first to achieve that result take precedence.
You should not leave your ordering to things out of your control such as hash ordering, thread scheduling etc.
This also means that we do not apply _artificial_ orderings such as "Order alphabetically" to achieve our determinism.
Instead lean on the fact that the Events you are consuming are immutable and ordered, and thus, deterministic.

## Further reading

### Command Query Responsibility Segregation (CQRS)

The architectural style that segregates the part of the system that writes and maintains state, from the parts of the system that is used to read and query data.

* [CQRS Journey](https://docs.microsoft.com/en-us/previous-versions/msp-n-p/jj554200(v%3dpandp.10))
* [CQRS (Azure Architecture patterns reference)](https://docs.microsoft.com/en-us/azure/architecture/patterns/cqrs)
* [Udi Dahan - Clarified CQRS](http://udidahan.com/2009/12/09/clarified-cqrs/)
* [Martin Fowler - CQRS](https://martinfowler.com/bliki/CQRS.html)

### Event Sourcing

The architectural style that captures state changes as a sequence of Business Events.
Events can then be replayed back to re-hydrate state, or produce read-models.

* [CQRS Journey - Introducing Event Sourcing](https://docs.microsoft.com/en-us/previous-versions/msp-n-p/jj591559(v%3dpandp.10))

### ISO-8601 (Date and time formats)

The standard for formatting dates and times.
Of particular note here is the:

* [UTC Time zone](https://en.wikipedia.org/wiki/ISO_8601#Coordinated_Universal_Time_(UTC))
* [Durations](https://en.wikipedia.org/wiki/ISO_8601#Durations)
