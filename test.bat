@echo off
set num=%1%
echo ==compile problem %num%==
javac src/%num%/Main.java
echo ==test problem %num%==
java -cp src/%num% Main < src/%num%/test.in