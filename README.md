# SimpleEMS
A text based event management langauge.
The purpose of the language is to provide a language for writing queries about reservations.

## Description:
While the original goal of this language was to serve as a query system for event management, the language of reserving spaces is relevant to any sort of reservation system. E.g. Hotel rooms, flight seats, zipcars/rental cars, in addition to conferences rooms.

The base of the language is still centered in the original problem for this language to solve, reserving study and conference rooms at Harvey Mudd College. The language can be easily altered to make it more intuitive for their domain.

If time allows in this project, we seek to add additional domain words to the language.

## Current State: 
An API for basic event management. 
Can handle about a week of events that must be delineated by hours.

Currently, users can make rooms and then reserve those rooms for periods of time with hour-granularity. 

## Implementation:
The API is provided through the room manager class.
The room manager should be initialized and then can be altered by making method calls.

Other objects should not be accessed, and all desirable changes should be changeable using queries (or single Strings).
