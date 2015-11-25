# Alex Putman Critique

## Parsing AST

So I can't find the paper prototype of your DSL, so I can't 
comment on how you can actually go about parsing it. But I 
can discuss your AST for your bit. 

I see that you have different case classes that all extend 
Filter. This seems like a fine way of going about this but 
the one thing I noticed is that they all have different 
functionality and don't really account for multiple types of info. Since
I don't have your prototype, I don't know if this is a problem
or not, but if you have multiple types of information that can
represent those case classes, you might need to make multiple 
case classes.

The other issue I could possibly see if the fact that you only 
have one smt that can be applied. Maybe reword the class Thing, because
I can't really understand what it is representing, and the name 
doesn't really help that at all. Is the time for that thing attached
to the room, it seems like a thing can only be a building, room, or 
time when I was thinking it would be a combination of these. 
Comments might also help here. 
