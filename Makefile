src/MaxGapTester.class: src/MaxGapTester.java
	javac src/*.java

run: src/MaxGapTester.class
	java -cp src MaxGapTester ${n}
