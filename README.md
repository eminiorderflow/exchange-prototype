# Candidate Project

-- How to run the project?

First package into jar using:

```./mvnw package```

OR (if mvn is added as global environment variable)

```mvn package```

THEN (in target folder)

```java -jar tick-monitor-0.0.1-SNAPSHOT.jar```

--  Which assumptions you made while developing?

I assumed the data to be linearly flowing, that is tick is in sequence of time.
Later found that tick could have time mismatch, so I would have used a SortedMap instead of LinkedMap if I had more time.

Second assumption was, the frequency of tick flow is constant.
This assumption was used for removing older ticks from memory which are more than 60 seconds old.
This is a constant time solution for removing older ticks. Without the assumption, O(nlogn) or O(n) solution shall be used to remove older ticks.

-- What would you improve if you had more time?

a. Deliver a more time optimized solution with higher level of concurrency.

b. Write unit and integration tests or probably TDD if the development culture demands.

c. Make lesser assumptions.

--  And, whether you liked the challenge or not?

I liked it. I enjoy building low latency projects and trading systems as a part of my hobby for options trading. 
However, since I was working on a production issue this week, I wrote this exercise in a very time constrained window.



