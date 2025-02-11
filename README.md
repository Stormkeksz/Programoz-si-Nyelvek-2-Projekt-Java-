# Statikus HTML Generátor

Ez a projekt egy statikus HTML generátor, amely egy megadott gyökérkönyvtárban található képek alapján automatikusan HTML fájlokat hoz létre. A projekt célja egy olyan rendszer megvalósítása volt, amely támogatja a könyvtárszerkezet böngészését és biztosít egy törlési funkciót is.

## Funkcionalitás

- **Index.html fájl létrehozása minden mappában:**  
  A program minden mappában létrehoz egy `index.html` fájlt.
- **Képoldalak generálása:**  
  Minden képhez készít egy azonos nevű `.html` fájlt.
- **Mappa szerkezet kezelése:**  
  Kezeli a gyökér-gyerek mappa szerkezetet, beleértve az üres és képeket tartalmazó mappákat.
- **Könyvtárak közötti böngészés:**  
  Lehetővé teszi a könyvtárak közötti böngészést.
- **Törlési funkció:**  
  Tartalmaz egy törlési funkciót (`Clean.java`), amely eltávolítja a generált HTML fájlokat.
- **Hibakezelés:**  
  Megfelelő hibakezeléssel rendelkezik.

## Használati útmutató

### Program futtatása terminálból

1. **Navigálj a program könyvtárába:**
   ```bash
   cd "program_könyvtára"
   ```
2. **Fordítsd le a programot:**
   ```bash
   javac Main.java
   ```
3. **Futtasd a programot a gyökérkönyvtár megadásával:**
   ```bash
   java Main "gyökérkönyvtár relatív elérési útja"
   ```
4. **A fájlok legenerálódnak a megfelelő helyeken.**

### Generált fájlok törlése

1. **Fordítsd le a törlő programot:**
   ```bash
   javac Clean.java
   ```
2. **Futtasd a törlési műveletet:**
   ```bash
   java Clean "gyökérkönyvtár relatív elérési útja"
   ```



