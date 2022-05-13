<h1 align="center">
Programozás beadandó
</h1>

***
***

## Fájlok és tartalmuk: 
### Metódusokról:
#### Bemenő paraméterei (szinte mindig) `ArrayList<Students>`
* `DataOfStudents.xml`: Tanulók adatait tartalmazó xml fájl.
* `xmlWriteStudents` & `xmlReadStudents`: xml fájlba írás és olvasás.
* `mainMenu` - A program működtető része, jelentős metódusokat tartalmaz
  * `menuInterface` - Listában megjeleníti a választható parancsokat
  * `listStudents` - Tanulók törlése
  * `addNewStudent` - Tanuló hozzáadása 
    * _(Minden adat megadása sorrend szerint)_
  * `modifyStudent` - Tanuló módosítása
    * _(Választható melyiket szeretnénk)_
  * `deleteStudent` - Tanuló törlése (ID alapján)
  * `findStudent` - Tanuló megkeresése (ID alapján)
* `validator` Ellenőrzi a megadott emial, dátum és tel. számokat,
hogy tényleg olyan formátumban lettek-e megadva
  * Nincs kritérium az alábbiakra: `name`, `birthPlace`, `address`, `nameOfCaretaker`

## Tanulók adatai
* MINDEN adat `String` formátumú, a tanulók
`ArrayList<String>`-be vannak mentve.
#### Tulajdonságok és adatok:
* `name`
* `birthPlace`
* `birthYear`
* `address`
* `phoneNumber`
* `email`
* `nameOfCaretaker`   - Gondviselő
* `numberOfCaretaker` - Gondviselő
 