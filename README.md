# Simple Anagram Service

## BUILD
````
git clone https://github.com/mg-3/anagram.git

./gradlew assemble
````

## RUN
````
java -jar build/libs/anagram-0.0.1-SNAPSHOT.jar
````

The service makes a few assumptions. 

1. Using a simple in-memory db so when service is restarted any dictionary additions will be lost
2. The algorithm to generate permutations could possibly improved for very large words.  Beyond a word length of 10 an 
UnsupportedOperationException will be thrown
3.  