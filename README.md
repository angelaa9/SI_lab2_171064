# Втора лабораториска вежба по Софтверско инженерство
## Ангела Шуменковски, бр. на индекс 171064
### Група на код:
Ја добив групата на код 5

### Control Flow Graph

![171064](https://user-images.githubusercontent.com/62511348/84208534-419f1000-aab4-11ea-9ff6-36a57d097542.jpg)

### Цикломатска комплексност
Цикломатската комплексност ја одредуваме така што ги броиме регионите во графот. Може да заклучиме дека цикломатската комплексност е 5 и имаме толку независни патеки.

### Тест случаи според критериумот Every Branch Test
    
    public class SILab2Test {
    private List<String> createList(String... list) {
        return new ArrayList<>(Arrays.asList(list));
    }
    @Test
    void EveryBranchTest() {
        IllegalArgumentException ex;

        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(null));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        assertEquals("#, #, #, #, #", SILab2.function(createList("#, #, #, #, #")));
        assertEquals("#, 2, #, 2, #", SILab2.function(createList("#, 0, #, 0, #")));
    }
    }
    
### Тест случаи според критериумот Multiple Conditions Test 
    
    public class SILab2Test {
    private List<String> createList(String... list) {
        return new ArrayList<>(Arrays.asList(list));
    }
    @Test
    void multipleConditionsTest() {
    //if (i - 1 >= 0 && list.get(i - 1).equals("#")) { //9
    //F && X 
    //T && F

	assertEquals("0,0,1", SILab2.function(createList("0,0,0,#")));
    assertEquals("0,0,1", SILab2.function(createList("0,0,0,#")));

    //if (i + 1 < list.size() && list.get(i + 1).equals("#")) { //12
    //F && X
    //T && F

	assertEquals("1,0,0", SILab2.function(createList("#,0,0,0")));
    assertEquals("1,0,0", SILab2.function(createList("#,0,0,0")));
    }  
    }
    
### Објаснување на напишаните unit tests

#### Објаснување на тестовите од EveryBranchTest:

Според направената табела во excel имаме 3 тест случаи преку кои се изминуваат сите branches од графот.

* Случај 1: негативна вредност за листата - следува исклучок "List length should be greater than 0".
* Случај 2: стринг на влез - "#, #, #, #, #"- така што се добива ист излез бидејќи нема ниту една 0 за која треба да се пресмета вредност.
* Случај 3: стринг на влез - "#, 0, #, 0, #", - излез - "#, 2, #, 2, #" - на местото на секоја 0 се враќа вкупниот број на тараби до неа.

#### Објаснување на тестовите од МultipleConditionsTest:

Двата теста се со еден логички оператор && така што ги тестираме следните случаи:

* F && X - Kога првиот дел од условот е неточен тогаш вториот дел не се ни прегледува. (се наоѓаме на почетокот од листата и секако од лево нема да се прави проверка за бомба)
* T && F - Случај кога првиот е точен, а вториот неточен. (не сме на почеток на листа, но лево од нулата немаме тараба)

* F && X - Кога првиот дел од условот е неточен тогаш вториот дел не се ни прегледува. (се наоѓаме на крајот од листата и секако од десно нема да се прави проверка за бомба)
* T && F - Случај кога првиот е точен, а вториот неточен. (не сме на крај на листа, но десно од нулата немаме тараба)

Логичкиот оператор && е точен само кога и двата услови се точни.
За секој тест случај даваме таков влез така што тој би го задоволил конкретниот случај.
