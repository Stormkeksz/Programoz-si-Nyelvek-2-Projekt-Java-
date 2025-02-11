# Programozási-Nyelvek-2-Projekt-
A tárgy teljesítéséhez szükséges volt készítenünk egy projektet amelyet meg is kellett védenünk.
Létre kellett hoznunk egy statikus HTML generátort, amelynek futás idejű paraméterként kellett megadni egy képeket tartalmazó gyökérkönyvtárat.
A program minden mappának egy index.html fájlt hoz létre illetve a képek nevével megegyező .html kiterjesztésű állományt.
Fontos volt: 
- több dokumentumból kellett állnia a projektnek
- a könyvtárban szükség volt gyökér-gyerek mappákra, ezekben üres illetve képekkel rendelkező mappákra
- könyvtáron belüli böngészési funkcióra
- szükség volt még egy törlési funkcióra amit a Clean.java-ban valósítottam meg

Program futtatása terminálon keresztül:
1. Javac Main.java 
2. Java Main.java "gyökérkönyvtár relatív elérési útja"
