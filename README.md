# SimpleEMS
A text based event management langauge.
The purpose of the language is to provide a language for writing queries about reservations.

## Description:
While the original goal of this language was to serve as a query system for event management, the language of reserving spaces is relevant to any sort of reservation system. E.g. Hotel rooms, flight seats, zipcars/rental cars, in addition to conferences rooms.

The base of the language is still centered in the original problem for this language to solve, reserving study and conference rooms at Harvey Mudd College. The language can be easily altered to make it more intuitive for their domain.

If time allows in this project, we seek to add additional domain words to the language.

## Current State: 
Accepts a program file and returns a mapping of descriptions to values.

(Sort-of, there was one bug I couldn't mash before the 11:59pm deadline where the DescriptorInterpreter could not be found in the control.scala class?)
_As of now, the control file does not compile_

## Running SimpleEMS:
1. Download and install sbt
2. run 'sbt run X' in the project's parent folder, where X is the location of the program
The expected output is text describing the mapping from fields to values given in the program.