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


## Actual Parsing Advice

Based on your AST, it seems like there isn't much variance in how users can
define different attributes of the language, which should make it 
easier to parse. I would stick to the Packrat Parser approach with 
a tree basically designed by how your syntax tree is being defined
in your prototype. 

I'm not sure how much help sugar will be since your AST classes really aren't 
that confusing and mostly just contain one value. You will still have to define
them as some function, so I'm not sure it would save very much time. 

I know the external lab is really simple but I think that might be the
best place for you to start since it deals with decently simple AST and syntax
which matches your syntax (probably, haven't seen it) more closely than our
other example which is picobot external. If you give me the paper prototype, 
I could add on to this. 
