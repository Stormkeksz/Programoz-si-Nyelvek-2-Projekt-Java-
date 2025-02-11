Statikus HTML Generátor
Ez a projekt egy statikus HTML generátor, amely egy megadott gyökérkönyvtárban található képek alapján automatikusan HTML fájlokat hoz létre. 
A projekt célja egy olyan rendszer megvalósítása volt, amely támogatja a könyvtárszerkezet böngészését és biztosít egy törlési funkciót is.

Funkcionalitás
- A program minden mappában létrehoz egy index.html fájlt.
- Minden képhez készít egy azonos nevű .html fájlt.
- Kezeli a gyökér-gyerek mappa szerkezetet, beleértve az üres és képeket tartalmazó mappákat.
- Lehetővé teszi a könyvtárak közötti böngészést.
- Tartalmaz egy törlési funkciót (Clean.java), amely eltávolítja a generált HTML fájlokat.
- Megfelelő hibakezeléssel rendelkezik.

Használati útmutató
Program futtatása terminálból
1.	Navigálj a program könyvtárába:
cd "program_könyvtára"
2.	Fordítsd le a programot:
javac Main.java
3.	Futtasd a programot a gyökérkönyvtár megadásával:
java Main "gyökérkönyvtár relatív elérési útja"
4.	A fájlok legenerálódnak a megfelelő helyeken.
Generált fájlok törlése
1.	Fordítsd le a törlő programot:
javac Clean.java
2.	Futtasd a törlési műveletet:
java Clean "gyökérkönyvtár relatív elérési útja"
