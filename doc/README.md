#ADR Tools. 

##Install with hombrew: 
   `brew install adr-tools`
   
#Principal commands:
1- initialisation documentation
   `adr init`, create first file in doc/adr/0001-record-architecture-decisions.md

2- Create a new `adr new "It's my title"`, create in doc/adr/0002-It-s-my-title.md

3- Generate summer in specific file `adr generate toc > doc/ADR-SUMMER.md`

4- Generate graph from adr files, you needs graphviz install on your computer. And use this command to generate svg graph: `adr generate graph | dot -Tsvg > graph.svg`.


